package ru.innopolis.lesson_7_online_reflection;

public class Capucin extends Monkey {

    public int charming;
    protected  int harmfull;
    private int footSize;
    private final int tailLenght = 40;

    public Capucin() {
    }

    public Capucin(int charming) {
        this.charming = charming;
        this.footSize = 38;
        this.harmfull = 1;
    }

    public Capucin(int charming, int harmfull, int footSize) {
        this.charming = charming;
        this.harmfull = harmfull;
        this.footSize = footSize;
    }

    protected void washFace(){
        System.out.println("Face cleaned");
    }

    private void washEars(){
        System.out.println("Wash ears");
    }

    public void eatBananas(int count){
        System.out.println("eat " + count + " bananas");
    }

}
