package ru.innopolis.lesson_4_online_generice.doubleCode;

public class GenericContainer<T> {

    private T mInt;

    public T getmGeneric() {
        return mInt;
    }

    public void setmGeneric(T mInt) {
        this.mInt = mInt;
    }

    public GenericContainer (T mInt) {
        this.mInt = mInt;
    }


}
