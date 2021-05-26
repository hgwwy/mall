package com.young.consumer.mq;

import com.young.consumer.bean.TestMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataConsumer {

    @StreamListener(Sink.TEST_INPUT)
    public void onMessage(@Payload TestMsg message) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
