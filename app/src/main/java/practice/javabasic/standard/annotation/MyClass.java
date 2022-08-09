package practice.javabasic.standard.annotation;

@MyAnnotation // 적용대상이 TYPE인 경우
public class MyClass {
    @MyAnnotation // 적용대상이 FIELD인 경우
    int i;

    @MyAnnotation
    MyClass mc;
}
