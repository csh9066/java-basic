package practice.javabasic.standard.generic.FruitBoxEx2;

import java.util.ArrayList;

/**
 * extneds를 사용하면 자신과 상속관계들만 허용 하겠다라고 표현하는거임
 * &를 사용하면 상속관계가 아닌 이 타입의 인터페이스를 허용 하겠다라고 표현하는거임
 * 클래스가 단일 상속이 불가능한 것 처럼 제네릭도 마찬가지로 extends 키워드를 한개바께
 * 사용 못하지만 인터페이스는 &를 이용해 여러 타입만 받을 수 있도록 할 수 있음
 * ex) Runnable & Eatable
 *
 * @param <T> 타입 매개변수 라고 부름
 */
class Box<T extends Fruit & Eatable> {
    ArrayList<T> list = new ArrayList<>();

    void add(T item) {
        list.add(item);
    }

    T get(int i) {
        return list.get(i);
    }

    int size() {
        return list.size();
    }

    public String toString() {
        return list.toString();
    }

}
