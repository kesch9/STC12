package ru.innopolis.lesson_8_online_classloaders.classloaders2;

public class EuropeanHuman implements Human {
    @Override
    public void eat(String what, int howMany) {
        System.out.println("Eat");
    }

    @Override
    public void slep(int duration) {
        System.out.println("Sleep");
    }

    @Override
    public String saySmth() {
        return "I'm europe";
    }
}
