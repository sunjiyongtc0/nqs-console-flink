package com.eystar.console.startup;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eystar.console.startup.env.BaseFlink;
import com.eystar.console.startup.handler.message.DataMessage;
import com.eystar.console.startup.handler.message.HeartBeatMessage;
import com.eystar.console.startup.handler.parser.AbstractDataParser;
import com.eystar.console.startup.handler.parser.ParserContext;
import com.eystar.console.startup.sink.HeartClickHouseSink;
import com.eystar.console.startup.sink.TaskDataClickHouseSink;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;

import java.util.Properties;


public class ConsoleTaskDataMain  extends BaseFlink {

    public static void main(String[] args) throws Exception {
        ConsoleTaskDataMain topo = new ConsoleTaskDataMain();
        topo.run(ParameterTool.fromArgs(args));
    }


    @Override
    public String getJobName() {
        return "ConsoleTaskDataMain";
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
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<String>("data_upload", new SimpleStringSchema(), KafkaProperties());
        DataStreamSource<String> stream = env.addSource(consumer);
        ParserContext.init();
        DataStream<DataMessage> dataMessageStream = stream.flatMap(new FlatMapFunction<String, DataMessage>() {
            private static final long serialVersionUID = -6986783354031993339L;

            @Override
            public void flatMap(String msg, Collector<DataMessage> out) throws Exception {
                try {
                    if (StrUtil.isBlank(msg))
                        return;
                    JSONArray array = JSONArray.parseArray(msg);
                    for (int i = 0; i < array.size(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        DataMessage message = new DataMessage(object);
                        if (message.isBadMsg()) {
                            continue;
                        }
                        out.collect(message);
                    }
                } catch (Exception e) {
                    System.out.println("解析探针上报数据出错，本次上报的信息为 = \r\n" + msg+ e.getMessage());
                }
            }
        });

        dataMessageStream.addSink(new TaskDataClickHouseSink());

    }


    public static Properties KafkaProperties() {
        Properties props = new Properties();
        props.put("group.id", "clickhouse-taskdata");
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
