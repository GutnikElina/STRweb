package com.core;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CustomExclusionStrategy implements ExclusionStrategy {
    private final Class<?> typeToSkip; //задает тип класса, который будет пропущен при обработке JSON
    public CustomExclusionStrategy(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    //этот метод пропускает поле с именем salary или любое поле, помеченное аннотацией @ExcludeField
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        // пропуск поля salary
        if ("salary".equals(f.getName())) {
            return true;
        }
        // пропуск поля с аннотацией @ExcludeField
        return f.getAnnotation(ExcludeField.class) != null;
    }

    //этот метод пропускает целые классы, если их тип совпадает с typeToSkip
    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == typeToSkip);
    }
}
