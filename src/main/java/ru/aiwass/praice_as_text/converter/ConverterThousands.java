package ru.aiwass.praice_as_text.converter;

import java.util.List;

public class ConverterThousands extends Converter {

    private final int DETERMINANT_UNITS = 10;
    private final int DETERMINANT_TEENS = 20;
    private final int DETERMINANT_TENS = 100;

    public String collectText(int number) {
        StringBuilder textNumber = new StringBuilder();
        if (number % 1000 == 0) {
            textNumber.append(convertThousands(number / 1000));
        } else {
            List<Integer> ranksNumber = splitNumber(number);
            textNumber.append(convertThousands(ranksNumber.get(0))).append(" ")
                    .append(convert(ranksNumber.get(1)));
        }
        return textNumber.append(" ").append(getFormCurrency(number, Currency.RUB)).toString();
    }

    private String convertTensForThousands(int number) { //71
        StringBuilder textNumber = new StringBuilder();

        int lastDigit = number % 10;
        int tensPart = number / 10;

        if (lastDigit == 0) {
            textNumber.append(Numbers.TENS.get(tensPart));
        } else {
            textNumber.append(Numbers.TENS.get(tensPart)).append(" ")
                    .append(Numbers.UNITS_FOR_THOUSANDS.get(lastDigit));
        }
        return textNumber.toString();
    }

    private String convertHundredsForThousands(int number) { //1
        StringBuilder textNumber = new StringBuilder();

        int lastDigit = number % 100;//1
        int hundredsPart = number / 100;//1

        if (lastDigit == 0) {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart));
        } else if (lastDigit < DETERMINANT_UNITS) {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart)).append(" ")
                    .append(Numbers.UNITS_FOR_THOUSANDS.get(lastDigit));
        } else if (number % 100 < DETERMINANT_TEENS) {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart)).append(" ")
                    .append(Numbers.TEENS.get(lastDigit));
        } else {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart)).append(" ")
                    .append(convertTensForThousands(lastDigit));
        }
        return textNumber.toString();
    }

    private String convertThousands(int number) {
        StringBuilder textNumber = new StringBuilder();

        if (number < DETERMINANT_UNITS) {
            textNumber.append(Numbers.UNITS_FOR_THOUSANDS.get(number));
        } else if (number < DETERMINANT_TEENS) {
            textNumber.append(Numbers.TEENS.get(number));
        } else if (number < DETERMINANT_TENS) {
            textNumber.append(convertTensForThousands(number));
        } else {
            textNumber.append(convertHundredsForThousands(number));
        }

        return textNumber.append(" ").append(getFormRank(number, Rank.THOUSAND)).toString();
    }
}
