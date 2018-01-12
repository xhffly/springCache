package com.cyh;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

@Component
public class LocalGenerator implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder sb = new StringBuilder("authenticationCache");
        for (Object obj : objects) {
            sb.append("_" + obj.toString());
        }
        String key = sb.toString();
        System.out.println("Generated key: " + key);
        return key;
    }
}
