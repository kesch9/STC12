package ru.innopolis.lesson_10_online_new_java.java7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DВведите свою зарплату");
        Integer salary = scanner.nextInt();
        System.out.println("Input country");
        scanner.nextLine();
        String country = scanner.nextLine();
        NonFuncTaxCalc taxCalc = null;
        switch (country){
            case "Russia":
                taxCalc = new NonFuncTaxCalc() {
                    @Override
                    public double calculateTax(int summ) {
                        return summ*0.13;
                    }
                };
                break;
            case "USA":
                taxCalc = new NonFuncTaxCalc() {
                    @Override
                    public double calculateTax(int summ) {
                        return summ*0.26;
                    }
                };
                break;
            case "Angola":
                taxCalc = new NonFuncTaxCalc() {
                    @Override
                    public double calculateTax(int summ) {
                        return summ*0.50;
                    }
                };
                break;
            default:
                taxCalc = new NonFuncTaxCalc() {
                    @Override
                    public double calculateTax(int summ) {
                        return 0;
                    }
                };
                break;

        }
        System.out.println(taxCalc.calculateTax(salary));
    }

}
