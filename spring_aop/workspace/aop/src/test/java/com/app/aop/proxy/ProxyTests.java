package com.app.aop.proxy;

import com.app.aop.advice.SimpleHandler;
import com.app.aop.joinpoint.HelloService;
import com.app.aop.joinpoint.SimpleHelloService;
import com.app.aop.util.MethodMatcher;
import com.app.aop.util.NameMatchMethodMatcher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class ProxyTests {
    @Test
    public void testSayHello() {
        HelloService target = new SimpleHelloService();
        MethodMatcher matcher = new NameMatchMethodMatcher("sayHello");

        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                HelloService.class.getClassLoader(),
                new Class[]{HelloService.class},
                new SimpleHandler(target, matcher)
        );

        String result = proxy.sayHello("ted");
        assertThat("hello ted").isEqualTo(result);
    }

    @Test
    public void testSayGoodbye() {
        HelloService target = new SimpleHelloService();
        MethodMatcher matcher = new NameMatchMethodMatcher("sayGoodbye");

        HelloService proxy = (HelloService) Proxy.newProxyInstance(
                HelloService.class.getClassLoader(),
                new Class[]{HelloService.class},
                new SimpleHandler(target, matcher)
        );

        String result = proxy.sayGoodbye("ted");
        assertThat("goodbye ted!").isEqualTo(result);
    }
}









