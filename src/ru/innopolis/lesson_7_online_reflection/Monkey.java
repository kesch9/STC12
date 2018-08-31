package ru.innopolis.lesson_7_online_reflection;

public abstract class Monkey {

    private String name;
    public Integer age;
    private String country;
    private String subType;
    private final int numLegs = 2;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    private void saySmth(String speak){
        System.out.println(speak);
    }
}
