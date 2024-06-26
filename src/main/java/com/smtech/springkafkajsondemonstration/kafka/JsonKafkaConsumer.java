package com.smtech.springkafkajsondemonstration.kafka;

import com.smtech.springkafkajsondemonstration.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "firstJsonTopic", groupId = "myGroup")
    public void consume(User user) {
        LOGGER.info(String.format("Json Message Recived -> %s", user.toString()));

    }

}
