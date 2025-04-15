package com.app.aop.proxy;

import com.app.aop.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SampleServiceTests {
    @Autowired
    private SampleService sampleService;

    @Test
    public void testDoAdd(){
        log.info("result: {}", sampleService.doAdd("3", "7"));
    }
}
