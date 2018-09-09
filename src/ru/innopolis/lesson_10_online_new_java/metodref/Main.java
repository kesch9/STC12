package ru.innopolis.lesson_10_online_new_java.metodref;

public class Main {

    public static void main(String[] args) {
        iGreeter sayHi = Greeter::sayHi;
        sayHi.sayHi();

        Greeter hello = new Greeter();
        iGreeter sayHi2 = hello::sayHiGrightly;
        sayHi2.sayHi();

        iGreeter hello3 = () -> System.out.println("Salam");
        hello3.sayHi();
    }

}
