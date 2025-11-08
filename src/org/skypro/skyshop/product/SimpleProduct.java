package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    private int price;

    public SimpleProduct(String name, int price) throws IllegalArgumentException{
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Неверная цена.");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + " : " + this.price;
    }
}
