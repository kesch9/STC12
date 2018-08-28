package ru.innopolis.lesson_5_onlinne_io;

import ru.innopolis.lesson_5_onlinne_io.dataExample.Person;

import java.io.*;
import java.util.ArrayList;

public class ObjectExample {
    public static void main(String[] args) {
        String fileName = "people.dat";
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        personArrayList.add(new Person("Tom",35,1.3,true));
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(personArrayList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Person> newPersons = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            newPersons = (ArrayList<Person>)objectInputStream.readObject();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
