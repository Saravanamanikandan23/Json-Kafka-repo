package com.smtech.springkafkajsondemonstration.controller;

import com.smtech.springkafkajsondemonstration.kafka.JsonKafkaProducer;
import com.smtech.springkafkajsondemonstration.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController@RequestMapping("api/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    //http://localhost:8080/api/kafka/publish
    @PostMapping("/publish")
    public ResponseEntity<String>publish(User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to the kafka topic");

    }
}
