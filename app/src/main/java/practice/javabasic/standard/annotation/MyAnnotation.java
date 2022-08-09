package practice.javabasic.standard.annotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE_USE;

@Target({TYPE_USE})
public @interface MyAnnotation {
}
