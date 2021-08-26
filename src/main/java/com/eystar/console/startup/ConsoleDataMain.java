package com.eystar.console.startup;


import com.eystar.console.startup.env.BaseFlink;
import com.eystar.console.startup.handler.HeartBeatMessage;
import com.eystar.console.startup.sink.HeartClickHouseSink;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;


public class ConsoleDataMain  extends BaseFlink {

    public static void main(String[] args) throws Exception {
        ConsoleDataMain topo = new ConsoleDataMain();
        topo.run(ParameterTool.fromArgs(args));
    }



    @Override
    public String getJobName() {
        return "ConsoleDataMain";
    }

    @Override
    public String getConfigName() {
        return "spring-container.xml";
    }

    @Override
    public String getPropertiesName() {
        return "config.properties";
    }

    @Override
    public void createTopology(StreamExecutionEnvironment builder) {
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<String>("heartbeat_info", new SimpleStringSchema(), KafkaProperties());
        DataStreamSource<String> stream = env.addSource(consumer);

        DataStream<HeartBeatMessage> streamMessage = stream.map(new MapFunction<String, HeartBeatMessage>() {
            public HeartBeatMessage map(String msg) throws Exception {
                HeartBeatMessage message = new HeartBeatMessage(msg);
                return message;
            }
        });

        DataStream<HeartBeatMessage> streamAlert = streamMessage.filter(new FilterFunction<HeartBeatMessage>() {
            public boolean filter(HeartBeatMessage message) throws Exception {
                return !message.isBadMsg();
            }
        });
        streamAlert.addSink(new HeartClickHouseSink());

    }


    public static Properties KafkaProperties() {
        Properties props = new Properties();
        props.put("group.id", "spring-clickhouse1");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("bootstrap.servers", "test176:7792");
        props.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"eystar\" password=\"eystar8888\";");
        props.put("security.protocol", "SASL_PLAINTEXT");
        props.put("sasl.mechanism", "SCRAM-SHA-256");
        return props;
    }
}
