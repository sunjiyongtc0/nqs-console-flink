package com.eystar.console.startup;


import com.eystar.console.startup.env.BaseFlink;
import com.eystar.console.startup.handler.message.GwInfoMessage;
import com.eystar.console.startup.sink.ProbeClickHouseSink;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;


public class ConsoleProbeInfoDataMain extends BaseFlink {

    public static void main(String[] args) throws Exception {
        ConsoleProbeInfoDataMain topo = new ConsoleProbeInfoDataMain();
        topo.run(ParameterTool.fromArgs(args));
    }



    @Override
    public String getJobName() {
        return "ConsoleProbeInfoDataMain";
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
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<String>("gateway_info", new SimpleStringSchema(), KafkaProperties());
        DataStreamSource<String> stream = env.addSource(consumer);
        DataStream<GwInfoMessage> streamMessage = stream.map(new MapFunction<String, GwInfoMessage>() {
            public GwInfoMessage map(String msg) throws Exception {
                GwInfoMessage message = new GwInfoMessage(msg);
                return message;
            }
        });

        // 筛选算子(去除不完整数据)
        DataStream<GwInfoMessage> streamAlert = streamMessage.filter(new FilterFunction<GwInfoMessage>() {
            public boolean filter(GwInfoMessage message) throws Exception {
                return !message.isBadMsg();
            }
        });
        streamAlert.addSink(new ProbeClickHouseSink());

    }


    public static Properties KafkaProperties() {
        Properties props = new Properties();
        props.put("group.id", "clickhouse-pinfo");
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
