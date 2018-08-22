package ru.innopolis.lesson_3_online_collection;

public class PersonDto {

    private int id;
    private String fio;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return fio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public PersonDto(int id, String fio, int age) {
        this.id = id;
        this.fio = fio;
        this.age = age;
    }
}
