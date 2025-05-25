package com.example.customAnotation.aspect;

import com.example.customAnotation.annotation.PreventDuplicate;
import com.example.customAnotation.dto.DuplicateCheckResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.*;

@Aspect
@Component
public class PreventDuplicateAspect {

    @Around("@annotation(preventDuplicate)")
    public Object checkDuplicates(ProceedingJoinPoint joinPoint, PreventDuplicate preventDuplicate) throws Throwable {
        Object result = joinPoint.proceed();

        if (result instanceof Collection<?>) {
            return handleCollection((Collection<?>) result);
        } else if (result != null && result.getClass().isArray()) {
            Object[] array = (Object[]) result;
            return handleCollection(Arrays.asList(array));
        }

        return result;
    }

    private <T> DuplicateCheckResponse<T> handleCollection(Collection<T> collection) {
        Set<T> duplicates = findDuplicates(collection);
        return new DuplicateCheckResponse<>(collection, duplicates);
    }

    private <T> Set<T> findDuplicates(Collection<T> collection) {
        Set<T> seen = new HashSet<>();
        Set<T> duplicates = new HashSet<>();
        for (T item : collection) {
            if (!seen.add(item)) {
                duplicates.add(item);
            }
        }
        return duplicates;
    }
}
