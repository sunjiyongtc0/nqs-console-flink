package com.eystar.console.startup.kafka;

public class KafkaMessageProducer {
    public static void send(String topic, String msg) {
        System.out.println("topic:"+topic+"msg:"+msg);
    }
}
