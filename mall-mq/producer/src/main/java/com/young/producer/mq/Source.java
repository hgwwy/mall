package com.young.producer.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {

    @Output("mall-test-output")
    MessageChannel testOutput();

}
