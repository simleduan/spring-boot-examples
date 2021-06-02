package com.neo.thirteen.aonymousClasses;

/**
 * create by xiaocai on 2021/5/10 14:04
 **/
public class AnimalTest {

    private final String ANIMAL = "动物";
    private String NEWANIMAL = "NEWANIMAL";

    public void accessTest() {
        System.out.println("匿名内部类访问其外部类方法");
    }

    class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public void printAnimalName() {
            System.out.println(bird.name);
        }
    }

    // 鸟类，匿名子类，继承自Animal类，可以覆写父类方法
    Animal bird = new Animal("布谷鸟") {

        @Override
        public void printAnimalName() {
            accessTest();                // 访问外部类成员
            System.out.println(ANIMAL);  // 访问外部类final修饰的变量
            System.out.println(NEWANIMAL);  // 访问外部类final修饰的变量
            super.printAnimalName();
        }
    };


    public void print() {
        bird.printAnimalName();
    }

    public static void main(String[] args) {

        AnimalTest animalTest = new AnimalTest();
        animalTest.print();
    }
}
