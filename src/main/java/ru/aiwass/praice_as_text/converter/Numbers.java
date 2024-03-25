package ru.aiwass.praice_as_text.converter;

import java.util.HashMap;
import java.util.Map;

public final class Numbers {
     static final Map<Integer, String> UNITS = new HashMap<>();

     static  final Map<Integer, String> UNITS_FOR_THOUSANDS = new HashMap<>();

     static final Map<Integer, String> TEENS = new HashMap<>();

     static final Map<Integer, String> TENS = new HashMap<>();

     static final Map<Integer, String> HUNDREDS = new HashMap<>();

    static {
        UNITS_FOR_THOUSANDS.put(1, "одна");
        UNITS_FOR_THOUSANDS.put(2, "две");
        UNITS_FOR_THOUSANDS.put(3, "три");
        UNITS_FOR_THOUSANDS.put(4, "четыре");
        UNITS_FOR_THOUSANDS.put(5, "пять");
        UNITS_FOR_THOUSANDS.put(6, "шесть");
        UNITS_FOR_THOUSANDS.put(7, "семь");
        UNITS_FOR_THOUSANDS.put(8, "восемь");
        UNITS_FOR_THOUSANDS.put(9, "девять");

        UNITS.put(0, "ноль");
        UNITS.put(1, "один");
        UNITS.put(2, "два");
        UNITS.put(3, "три");
        UNITS.put(4, "четыре");
        UNITS.put(5, "пять");
        UNITS.put(6, "шесть");
        UNITS.put(7, "семь");
        UNITS.put(8, "восемь");
        UNITS.put(9, "девять");

        TEENS.put(10, "десять");
        TEENS.put(11, "одиннадцать");
        TEENS.put(12, "двенадцать");
        TEENS.put(13, "тринадцать");
        TEENS.put(14, "четырнадцать");
        TEENS.put(15, "пятнадцать");
        TEENS.put(16, "шестнадцать");
        TEENS.put(17, "семнадцать");
        TEENS.put(18, "восемнадцать");
        TEENS.put(19, "девятнадцать");

        TENS.put(2, "двадцать");
        TENS.put(3, "тридцать");
        TENS.put(4, "сорок");
        TENS.put(5, "пятьдесят");
        TENS.put(6, "шестьдесят");
        TENS.put(7, "семьдесят");
        TENS.put(8, "восемьдесят");
        TENS.put(9, "девяносто");

        HUNDREDS.put(1, "сто");
        HUNDREDS.put(2, "двести");
        HUNDREDS.put(3, "триста");
        HUNDREDS.put(4, "четыреста");
        HUNDREDS.put(5, "пятьсот");
        HUNDREDS.put(6, "шестьсот");
        HUNDREDS.put(7, "семьсот");
        HUNDREDS.put(8, "восемьсот");
        HUNDREDS.put(9, "девятьсот");
    }
}
