package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int basePrice;
    private double discountInPercentInt; // от 0 до 100
    private Product[] products = new Product[5];
    private boolean isPriceCalculated;

    public DiscountedProduct(String name, int basePrice, int discountInPercentInt) {
        super(name);
        this.basePrice = basePrice;
        this.discountInPercentInt = discountInPercentInt;
    }

    @Override
    public int getPrice() {
        if (!isPriceCalculated) {
            double percent;
            percent = basePrice * (discountInPercentInt / 100);
            basePrice = (int) (basePrice - percent);
            isPriceCalculated = true;
        }
        return basePrice;
    }

    @Override
    public String toString() {
        return this.getName() + " : " + this.getPrice() + " (" + this.discountInPercentInt + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
