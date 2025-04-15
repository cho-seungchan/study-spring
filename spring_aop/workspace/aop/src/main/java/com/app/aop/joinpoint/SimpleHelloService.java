package com.app.aop.joinpoint;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public String sayGoodbye(String name) {
        return "goodbye " + name;
    }
}
