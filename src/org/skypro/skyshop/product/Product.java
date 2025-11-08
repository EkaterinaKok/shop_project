package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) throws IllegalArgumentException{
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Неверное название продукта.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

}
