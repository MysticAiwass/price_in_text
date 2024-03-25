package ru.aiwass.praice_as_text.converter;

public enum Currency {
    RUB("рубль", "рубля", "рублей");
    public final String singular;
    public final String dual;
    public final String plural;

    Currency(String singular, String dual, String plural) {
        this.singular = singular;
        this.dual = dual;
        this.plural = plural;
    }
}
