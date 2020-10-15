package com.softwarefoundation.consumer;

import com.softwarefoundation.config.KafkaConfigProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;

public class MensagemConsumer {


    public static void main(String[] args) throws InterruptedException {
        try(KafkaConsumer<String,String> consumer = new KafkaConsumer<>(KafkaConfigProperties.Consumer.getProperties())){
            consumer.subscribe(Arrays.asList("topic-mensagem"));

            while (true){
                ConsumerRecords<String,String> records = consumer.poll(Duration.ofSeconds(1));
                for(ConsumerRecord<String,String> record : records){
                    System.out.println(String.format("Recebendo: %s", record.value()));
                }
                Thread.sleep(500);
            }
        }
    }

}
