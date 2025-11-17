package org.skypro.skyshop.articles;

import java.io.IOException;

public class BestResultNotFound extends IOException {

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
