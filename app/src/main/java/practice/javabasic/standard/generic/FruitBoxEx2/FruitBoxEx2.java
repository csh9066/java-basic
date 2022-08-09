package practice.javabasic.standard.generic.FruitBoxEx2;

public class FruitBoxEx2 {

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Grape> grapeBox = new Box<>();
//        Box<Toy> toyBox = new Box<Toy>(); // 컴파일 오류
        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        fruitBox.add(new Fruit());

//        appleBox.add(new Fruit()); // 컴파일 오류부모 타입은 받을 수 없음
        appleBox.add(new Apple());

        grapeBox.add(new Grape());


    }

}

