package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    private final int FIX_PRICE = 50;
    private Product[] products = new Product[5];

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return this.getName() + " : " + this.getPrice() + " (Фиксированная цена: " + FIX_PRICE + ")";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
