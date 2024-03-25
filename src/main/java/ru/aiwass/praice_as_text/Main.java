package ru.aiwass.praice_as_text;


import ru.aiwass.praice_as_text.converter.Converter;
import ru.aiwass.praice_as_text.converter.ConverterMillions;
import ru.aiwass.praice_as_text.converter.ConverterThousands;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textNumber = null;
        Converter converter = new Converter();
        ConverterThousands converterThousands = new ConverterThousands();
        ConverterMillions converterMillion = new ConverterMillions();

        System.out.println("Добро пожаловать в программу конвертер. Чтобы выйти из программы введите '-1'. " +
                "Введите положительное число");
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    System.out.println("Выход из программы.");
                    break;
                }
                if (number < 0) {
                    System.out.println("Ошибка: отрицательные числа не поддерживаются. Пожалуйста, введите положительное число.");
                    continue;
                }
                if (number < 1000) {
                    textNumber = converter.collectText(number);
                } else if (number < 1_000_000) {
                    textNumber = converterThousands.collectText(number);
                } else if (number < 1_000_000_000) {
                    textNumber = converterMillion.collectText(number);
                }
                System.out.println(textNumber);
            } else {
                System.out.println("Ошибка: введено не число. Попробуйте еще раз.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
