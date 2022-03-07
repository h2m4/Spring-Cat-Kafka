package com.Producer;


import com.Common.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageProducer {

    private KafkaTemplate kafka;

    @Autowired
    public MessageProducer(KafkaTemplate kafka) {
        this.kafka = kafka;
    }

    public void sendMessage(Cat cat) {
        kafka.send("spring-cat-cute-cat-topic", cat);
    }
}
