package com.Controller;

import com.Common.Cat;
import com.Producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin (origins = "*")
public class CatController {
    private MessageProducer messageProducer;

    @Autowired
    public CatController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping (value = "/addcat", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Cat postCatInfo(@RequestBody Cat cat) {
        log.info("post a cat to server:"+cat);
        messageProducer.sendMessage(cat);
        log.info("send a cat to kafka topic:"+cat);
        return cat;
    }

    @GetMapping(value = "/getcat", produces = "application/json")
    public Cat getCat() {
        Cat cat = new Cat("Emily",
                "female",
                 true,
                 true,
                 true,
                "../static/images/cat2.jpeg");

        return cat;
    }

}
