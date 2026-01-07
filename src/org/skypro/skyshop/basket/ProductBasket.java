package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private List<Product> products = new LinkedList<>();
    private int total;
    private int sizeArr = 0;

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        } else System.out.println("Невозможно добавить пустой продукт!");
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
        products.clear();
        System.out.println("Корзина очищена.");
    }

    // Добавление метода удаления продукта по имени из корзины
    public List<Product> deleteProduct(String name) {
        Iterator<Product> iterator = products.iterator();
        List<Product> deleteList = new LinkedList<>();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (element.getName().contains(name)) {
                deleteList.add(element);
                iterator.remove();
            }
        }
        if (deleteList.size() == 0) System.out.println("\nСписок пуст.");
        return deleteList;
    }

    public void printBasket() {
        System.out.println(products);
    }

}