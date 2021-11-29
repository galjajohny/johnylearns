package galja_johny.tests;

import org.junit.jupiter.api.Test;

public class Cat {
    String name;
    int age;

    void printName() {
        System.out.println(name);
    }

    void celebrateBday() {
        age = age + 1;
    }

    void printAge() {
        System.out.println(age);
    }

}

class TestCat {
    @Test
    void test1() {
        Cat vasya = new Cat();
        Cat snezhok = new Cat();

        vasya.name = "Vasya";
        vasya.age = 5;
        vasya.printName();
        vasya.printAge();
        vasya.celebrateBday();
        vasya.printAge();
    }
}