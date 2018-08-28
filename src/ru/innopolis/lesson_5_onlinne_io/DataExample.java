package ru.innopolis.lesson_5_onlinne_io;

import java.io.*;
import ru.innopolis.lesson_5_onlinne_io.dataExample.Person;

public class DataExample {
    public static void main(String[] args) {

        Person person = new Person("Tom", 35,1.9,true);
        try(DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.bin"))){
            dataOutputStream.writeUTF(person.name);
            dataOutputStream.writeInt(person.age);
            dataOutputStream.writeDouble(person.height);
            dataOutputStream.writeBoolean(person.married);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.bin"))){

            String name = dataInputStream.readUTF();
            int age = dataInputStream.readInt();
            double height = dataInputStream.readDouble();
            boolean married = dataInputStream.readBoolean();
            Person person1 = new Person(name,age,height,married);
            //System.out.println("Имя: %s, возраст %d, рост: %f, брак: %b", name, age, height, married);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

