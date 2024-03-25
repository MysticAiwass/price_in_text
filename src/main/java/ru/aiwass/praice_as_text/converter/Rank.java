package ru.aiwass.praice_as_text.converter;

public enum Rank {
    THOUSAND("тысяча", "тысячи", "тысяч"),
    MILLION("миллион", "миллиона", "миллионов"),
    BILLION("миллиард", "миллиарда ", "миллиардов");

   public final String singular;
    public final String dual;
    public final String plural;

    Rank(String singular, String dual, String plural) {
        this.singular = singular;
        this.dual = dual;
        this.plural = plural;
    }
}
