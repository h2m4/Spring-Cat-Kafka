package com.Consumer;


import com.Common.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @KafkaListener (topics = "spring-cat-cute-cat-topic")
    public void listenCatMessage(Cat cat) {
        log.info("Cat message is listened:"+cat);
    }
}
