package practice.javabasic.standard.generic.wildcard;

public class Juicer<T extends Fruit> {
    // Fruit 과 자식 타입들 까지 다 받겠다
    static Juice makeJuice(Box<? extends Fruit> box) {
        String tmp = " ";
        for (Fruit fruit : box.getList()) {
            tmp += fruit + " ";
        }
        return new Juice(tmp);
    }
}
