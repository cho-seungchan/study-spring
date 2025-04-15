package com.app.aop.util;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class NameMatchMethodMatcher implements MethodMatcher {
    private final String methodName;

    @Override
    public boolean matches(Method method) {
        return methodName.equals(method.getName());
    }
}
