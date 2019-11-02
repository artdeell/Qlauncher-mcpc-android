package org.lwjgl.util.mapped;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MappedType {
    int align() default 4;

    boolean autoGenerateOffsets() default true;

    boolean cacheLinePadding() default false;

    int padding() default 0;
}
