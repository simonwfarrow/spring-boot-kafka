package com.swf.poc.kafka.springbootkafka.controllers;


import com.swf.poc.kafka.springbootkafka.engine.Producer;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private Counter msgCount;
    private final Producer producer;
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);



    @Autowired
    KafkaController(Producer producer, MeterRegistry registry){
        this.producer = producer;
        this.msgCount = registry.counter("published_message_count");
    }


    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        this.producer.sendMessage(message);
        if (this.msgCount!=null){
            this.msgCount.increment();
        } else {
            logger.info("Metrics counter is null");
        }
    }
}
