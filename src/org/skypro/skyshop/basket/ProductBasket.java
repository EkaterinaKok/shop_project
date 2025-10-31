package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int total;
    private int sizeArr;

    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Невозможно добавить пустой продукт.");
            return;
        }

        if (sizeArr >= products.length) {
            System.out.println("Корзина заполнена. Невозможно добавить продукт.");
            return;
        } else {
            products[sizeArr] = product;
            sizeArr++;
        }
    }

    public int total() {
        if (products == null) {
            System.out.println("В корзине пусто.");
            return -1;
        }
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            } else {
                break;
            }
        }
        return total;
    }

    //Печать корзины
    public void print() {
        int count = 0;
        boolean hasProducts = false;

        if (products != null) {
            for (Product product : products) {
                if (product != null) { // Если элемент не null
                    hasProducts = true;
                    if (product.isSpecial()) {
                        count++;
                    }
                    System.out.println(product);
                }
            }
        }

        // Если не нашли ни одного товара
        if (!hasProducts) {
            System.out.println("В корзине пусто.");
            return;
        }

        printTotal();
        System.out.println("Товаров по специальной цене: " + count);
    }

    public void printTotal() {
        boolean hasProducts = false;

        for (Product product : products) {
            if (product != null) { // Если элемент не null
                hasProducts = true;
                break;
            }
        }
        if (!hasProducts) {
            System.out.println("В корзине пусто.");
            return;
        }
        System.out.println("---------------------");
        System.out.println("Итого: " + this.total() + " руб.");
    }

    public boolean productSearch(String name) {

        if (name == null || name.isEmpty()) {
            System.out.println("Нет данных для поиска продукта.");
            return false;
        }

        if (products == null) {
            System.out.println("Корзина пуста.");
            return false;
        }

        for (Product product : products) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                System.out.println("Продукт найден: " + name);
                return true;
            }
        }
        System.out.println("Продукт не найден: " + name);
        return false;
    }

    public void clearArr() {
        Arrays.fill(products, null);
        System.out.println("Корзина очищена.");
    }
}