package org.canzuo.spring.rocketmq.producer;

import org.canzuo.spring.rocketmq.ProducerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = {ProducerApplication.class})
public class ProducerApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {

    }

}
