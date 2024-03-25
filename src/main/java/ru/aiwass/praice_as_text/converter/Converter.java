package ru.aiwass.praice_as_text.converter;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    private final  int DETERMINANT_UNITS = 10;
    private final  int DETERMINANT_TEENS = 20;
    private final  int DETERMINANT_TENS = 100;

    public String collectText(int number) {
        return convert(number) + " " + getFormCurrency(number, Currency.RUB);
    }

    protected String convert(int number) {
        StringBuilder textNumber = new StringBuilder();
        if (number < DETERMINANT_UNITS) {
            textNumber.append(Numbers.UNITS.get(number));
        } else if (number < DETERMINANT_TEENS) {
            textNumber.append(Numbers.TEENS.get(number));
        } else if (number < DETERMINANT_TENS) {
            textNumber.append(convertTens(number));
        } else {
            textNumber.append(convertHundreds(number));
        }
        return textNumber.toString();
    }
    protected String convertTens(int number) {
        StringBuilder textNumber = new StringBuilder();

        int lastDigit = number % 10;
        int tensPart = number / 10;

        if (lastDigit == 0) {
            textNumber.append(Numbers.TENS.get(tensPart));
        } else {
            textNumber.append(Numbers.TENS.get(tensPart)).append(" ")
                    .append(Numbers.UNITS.get(lastDigit));
        }
        return textNumber.toString();
    }

    protected String convertHundreds(int number) {
        StringBuilder textNumber = new StringBuilder();

        int lastNumber = number % 100;
        int hundredsPart = number / 100;

        if (lastNumber == 0) {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart));
        } else if (number % 100 < DETERMINANT_UNITS) {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart)).append(" ")
                    .append(Numbers.UNITS.get(lastNumber));
        } else if (number % 100 < DETERMINANT_TEENS) {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart)).append(" ")
                    .append(Numbers.TEENS.get(lastNumber));
        } else {
            textNumber.append(Numbers.HUNDREDS.get(hundredsPart)).append(" ")
                    .append(convertTens(lastNumber));
        }
        return textNumber.toString();
    }

    protected static List<Integer> splitNumber(int number) {
        String numberStr = String.valueOf(number);
        List<Integer> splittedNumber = new ArrayList<>();
        while (!numberStr.isEmpty()) {
            int endIndex = Math.max(numberStr.length() - 3, 0);
            String group = numberStr.substring(endIndex);
            splittedNumber.add(0, Integer.parseInt(group));
            numberStr = numberStr.substring(0, endIndex);
        }

        return splittedNumber;
    }


    protected String getFormCurrency(int number, Currency currency) {
        int lastNumber = getLastTwoDigits(number);

        if (lastNumber == 1) {
            return currency.singular;
        } else if (lastNumber > 1 && lastNumber < 5) {
            return currency.dual;
        } else {
            return currency.plural;
        }
    }


    protected int getLastTwoDigits(int number) {
        List<Integer> splitNumber = splitNumber(number);

        int lastNumber = splitNumber.get(splitNumber.size() - 1) % 100;
        if (lastNumber < DETERMINANT_TEENS) {
            return lastNumber;
        } else {
            return lastNumber % 10;
        }

    }

    protected String getFormRank(int number, Rank rank) {
        String rankNumber;
        int lastNumber = getLastTwoDigits(number);

        if (lastNumber == 1) {
            rankNumber = rank.singular;
        } else if (lastNumber > 1 && lastNumber < 5) {
            rankNumber = rank.dual;
        } else {
            rankNumber = rank.plural;
        }
        return rankNumber;
    }
}
