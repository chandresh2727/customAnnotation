package com.example.customAnotation.aspect;

import com.example.customAnotation.annotation.Encrypted;
import com.example.customAnotation.util.EncryptionUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
public class EncryptionAspect {

    @Before("execution(* com.example.customAnotation..*(..))")
    public void encryptFields(JoinPoint joinPoint) throws IllegalAccessException {
        for (Object arg : joinPoint.getArgs()) {
            if (arg == null) continue;
            for (Field field : arg.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Encrypted.class)) {
                    field.setAccessible(true);
                    Object value = field.get(arg);
                    if (value instanceof String str) {
                        field.set(arg, EncryptionUtil.encrypt(str));
                    }
                }
            }
        }
    }
}
