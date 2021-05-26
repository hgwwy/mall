package com.young.producer.controller;

import com.young.producer.bean.TestMsg;
import com.young.producer.mq.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestProducerController {

    private final Source source;

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/send")
    public boolean send() {
        Message<TestMsg> msg = MessageBuilder.withPayload(
                TestMsg.builder()
                        .id(new Random().nextInt(100))
                        .name("测试消息发送" + Instant.now().toEpochMilli())
                        .createTime(new Date())
                        .build()
        ).build();
        log.info("生产者发送消息：{}", msg);
        return source.testOutput().send(msg);
    }

}
