package org.skypro.skyshop.articles;

public class BestResultNotFound extends NullPointerException{

    public BestResultNotFound() {
    }

    @Override
    public String getMessage() {
        return toString();
    }

    @Override
    public String toString() {
        return "Подходящий объект не найден!";
    }
}
