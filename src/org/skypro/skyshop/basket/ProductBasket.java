package org.skypro.skyshop.basket;

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
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            } else {
                System.out.println("В корзине пусто.");
                break;
            }
        }
        return total;
    }

    public void print() {
        if (products[0] != null) { //Входим в массив, если первый элемент не пустой
            for (Product product : products) {
                if (product == null) { //Если элемент внутри пустой, значит список окончен
                    break; // значит останавливаем цикл
                }
                System.out.println(product.getName() + " : " + product.getPrice());
            }
        } else System.out.println("В корзине пусто.");
    }

    public void printTotal() {
        print();
        System.out.println("---------------------");
        System.out.println("Итого: " + total() + " руб.");
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
    }

}