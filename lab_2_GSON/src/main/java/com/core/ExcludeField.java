package com.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //указывает, как долго аннотация будет храниться и доступна для использования
@Target({ElementType.FIELD})  //указывает, где может быть применена аннотация.
public @interface ExcludeField {
}

