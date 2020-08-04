package org.canzuo.spring.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication{
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @SpringBootApplication(scanBasePackages = "org.canzuo.spring.rocketmq.command")
    static class InnerConfig {

    }
}
