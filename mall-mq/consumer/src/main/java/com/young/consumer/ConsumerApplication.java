package com.young.consumer;

import com.young.consumer.mq.Sink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConsumerApplication.class);
    }

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(ConsumerApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        log.info("\n----------------------------如果是随机端口，这里就会显示错误端口------------------------------\n\t" +
                "DaoApplication is running! Access URLs:\n\t" +
                "Actuator: \t\thttp://localhost:" + port + path + "/actuator\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/swagger-ui/index.html\n" +
                "----------------------------------------------------------");
    }

}
