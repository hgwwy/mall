package com.young.consumer.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {

    String TEST_INPUT = "mall-test-input";

    @Input(TEST_INPUT)
    SubscribableChannel testInput();

}
