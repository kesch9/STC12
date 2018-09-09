package ru.innopolis.lesson_10_online_new_java.functional;

@FunctionalInterface
public interface TaxCalculator {
    double calculateTax(int summ);
}
