package org.skypro.skyshop.articles;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return this.getSearchTerm() + "\n" + this.getContentType();
    }

}
