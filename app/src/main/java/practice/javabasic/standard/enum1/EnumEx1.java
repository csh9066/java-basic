package practice.javabasic.standard.enum1;

import java.util.Arrays;

enum Direction {EAST, SOUTH, WEST, NORTH}

public class EnumEx1 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println(d1 instanceof Enum);

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1==d2 ? " + (d1 == d2)); // false
        System.out.println("d1==d2 ? " + (d1 == d3)); // true
        System.out.println("d1.eqauls(d3) ? " + d1.equals(d3)); // true

        Direction[] directions = Direction.values();

        Arrays.stream(directions).forEach(d -> {
            // name 문자열 반환, ordinal 순서 int로 반환
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        });
    }
}
