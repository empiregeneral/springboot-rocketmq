package org.canzuo.spring.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
    }

    @SpringBootApplication(scanBasePackages = {"org.canzuo.spring.rocketmq"})
    static class InnerConfigure {

    }


}
