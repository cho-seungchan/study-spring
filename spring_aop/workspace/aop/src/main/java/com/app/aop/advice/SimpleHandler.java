package com.app.aop.advice;

import com.app.aop.util.MethodMatcher;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class SimpleHandler implements InvocationHandler {
    private final Object target;
    private final MethodMatcher methodMatcher;

//    Throwable(Error까지 포함)
//    원본 객체가 어떤 예외를 던질지 모르기 때문에, 프록시는 포괄적으로(Error까지) 받아줘야 한다.
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        외부에서 주입받은 원본 객체와 매개변수를 invoke에 전달
//        invoke: 프록시가 원래 객체의 메소드를 호출할 때 대신 불리는 메소드
//        원본 객체의 메소드의 "리턴값"을 리턴한다.
        Object result = method.invoke(target, args);

//        PointCut: 리턴값이 문자열일 때, 메소드 이름이 설정해놓은 이름과 일치할 때
        if(result instanceof String && methodMatcher.matches(method)) {
            return ((String) result) + "!"; // Advice: 부가기능 추가
        }
//        아니라면 기존 리턴값 그대로 리턴
        return result;
    }
}

















