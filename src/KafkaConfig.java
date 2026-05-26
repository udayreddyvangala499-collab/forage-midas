package com.jpmc.midascore;

import com.jpmc.midascore.foundation.Transaction;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public JsonDeserializer<Transaction> transactionJsonDeserializer() {
        JsonDeserializer<Transaction> deserializer =
                new JsonDeserializer<>(Transaction.class);

        deserializer.addTrustedPackages("*");
        return deserializer;
    }
}