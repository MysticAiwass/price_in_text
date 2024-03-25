package ru.aiwass.praice_as_text.converter;

public class ConverterMillions extends ConverterThousands {

    private static final int MILLION = 1_000_000;
    private static final int THOUSAND = 1_000;

    @Override
    public String collectText(int number) {
        StringBuilder textNumber = new StringBuilder();
        int remainder = number % MILLION;
        int millions = number / MILLION;
        int thousand = (number / THOUSAND) % THOUSAND;

        if (number == 0){
            return textNumber.append(getFormCurrency(number, Currency.RUB)).toString();
        }

        if (remainder == 0) {
            textNumber.append(convert(millions)).append(" ")
                    .append(getFormRank(millions, Rank.MILLION));
        } else if (thousand == 0) {
            textNumber.append(convert(millions)).append(" ").
                    append(getFormRank(millions, Rank.MILLION)).append(" ")
                    .append(convert(remainder));
        } else {
            textNumber.append(convert(millions)).append(" ")
                    .append(getFormRank(millions, Rank.MILLION)).append(" ").append(super.collectText(remainder));
            return textNumber.toString();
        }
        return textNumber.append(" ").append(getFormCurrency(number, Currency.RUB)).toString();
    }
}

