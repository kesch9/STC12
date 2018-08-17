package ru.innopolis.lesson_1_online;

public class SomeClass {

    int myInt = 1;
    String myString = "String value";
    public void checkString(){
        String myString2 = myString;
        System.out.println(myString2 == myString);
        myString = "NewValue";
        System.out.println(myString2 == myString);
        String myString3 = "String value";
        System.out.println(myString2 == myString3);
    }

    public void checkInteger(){

        Integer a = 182;
        Integer b = 182;
        System.out.println(a == b);

    }

    public void operatorTest(){
        System.out.println(myString instanceof String);
        short myLong = 12;
        int myInt = myLong;
        boolean myBool = (true == true) ? true : false;
        System.out.println(myBool);
    }
}
