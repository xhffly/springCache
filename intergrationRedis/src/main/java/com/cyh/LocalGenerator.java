package com.cyh;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class LocalGenerator implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... objects) {

        StringBuilder sb = new StringBuilder();
        String className = o.getClass().getSimpleName();

        sb.append(className + "-");
        for (Object obj : objects) {
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}
