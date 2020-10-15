package com.softwarefoundation.producer;

import com.softwarefoundation.config.KafkaConfigProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MensagemProducer {

    private static final String KAFKA_TOPIC_MENSAGEM = "topic-mensagem";

    public static void main(String[] args) throws InterruptedException {
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(KafkaConfigProperties.Producer.getProperties())) {
            while (true) {
                ProducerRecord<String,String> record = getProducerRecord();
                producer.send(record);
                System.out.println(String.format("Enviando: %s",record.value()));
                Thread.sleep(500);
            }
        }

    }

    /**
     * Gera um record para ser enviando.
     *
     * @return ProducerRecord<String,String>
     */
    private static ProducerRecord<String, String> getProducerRecord() {
        ProducerRecord<String, String> record = new ProducerRecord(KAFKA_TOPIC_MENSAGEM, getMensagem());
        return record;
    }



    /**
     * Retorna, aleatóriamente, uma das mensagens existente no map.
     *
     * @return
     */
    private static String getMensagem() {
        Map<Integer, String> mensagens = new HashMap<>();
        mensagens.put(0, "Esse é o meu segredo, Capitão. Eu estou sempre com raiva");
        mensagens.put(1, "Grande homem em uma armadura de metal. Tire isso e o que você é?");
        mensagens.put(2, "Gênio, bilionário, playboy e filantropo.");
        mensagens.put(3, "Por que tão sério?");
        mensagens.put(4, "As vezes é preciso aprender a correr antes de começar a andar.");
        mensagens.put(5, "Nós caímos para aprendermos a nos levantar");
        return mensagens.get(new Random().nextInt(mensagens.size()));
    }

}
