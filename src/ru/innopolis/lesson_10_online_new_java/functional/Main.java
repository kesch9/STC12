package ru.innopolis.lesson_10_online_new_java.functional;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DВведите свою зарплату");
        Integer salary = scanner.nextInt();
        System.out.println("Input country");
        scanner.nextLine();
        String country = scanner.nextLine();
        TaxCalculator taxCalc = null;
        switch (country){
            case "Russia":
                taxCalc = (int summ) -> {return summ*0.13;};
            break;
            case "USA":
                taxCalc = summ -> summ*0.25;
            break;
            case "Angola":
                taxCalc = (int summ) -> {return summ*0.50;};
            break;
                default:
                    taxCalc = (int summ) -> {return 0;};


        }
        System.out.println(taxCalc.calculateTax(salary));
    }
}
