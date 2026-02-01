package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private HashMap<String, LinkedList<Product>> products = new HashMap<>();

    //Добавление продукта
    public void addProduct(Product product) {

        if (product == null) {
            System.out.println("Невозможно добавить пустой продукт!");
            return;
        }

        String name = product.getName();
        if (name == null || name.isEmpty()) {
            System.out.println("У продукта нет имени, добавление невозможно.");
            return;
        }

        LinkedList<Product> productList = products.computeIfAbsent(name, k -> new LinkedList<>());
        productList.add(product);

    }

    //Подсчет суммы
    public int total() {
       // int total = 0;

        if (products == null || products.isEmpty()) {
            System.out.println("В корзине пусто.");
            return -1;
        }

        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

// Подсчет специальных продуктов
    private long getSpecialCount(){
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }


    //Печать корзины
    public void print() {

        products.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .forEach(System.out::println);

        printTotal();
        System.out.println("Товаров по специальной цене: " + getSpecialCount());
    }

    //Вывод итога
    public void printTotal() {
        int totalAmount = total();
        if (products.isEmpty() || totalAmount == -1) {
            System.out.println("В корзине пусто.");
            return;
        }

        System.out.println("---------------------");
        System.out.println("Итого: " + totalAmount + " руб.");
    }

    //Поиск продукта по имени
    public boolean productSearch(String name) {

        if (name == null || name.isEmpty()) {
            System.out.println("Нет данных для поиска продукта.");
            return false;
        }

        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return false;
        }

        if (products.containsKey(name)) {
            System.out.println("Продукт найден: " + name);
            return true;
        } else {
            System.out.println("Продукт не найден: " + name);
            return false;
        }
    }

    //Очистка корзины
    public void clearArr() {
        products.clear();
        System.out.println("Корзина очищена.");
    }

    // Удаление продукта по имени из корзины
    public List<Product> deleteProduct(String name) {

        if (name == null || name.isEmpty()) {
            System.out.println("Нет данных для удаления продукта.");
            return new LinkedList<>();
        }

        List<Product> deletedList = new LinkedList<>();
        LinkedList<Product> productList = products.get(name);

        if (productList != null && !productList.isEmpty()) {
            // Перебираем и удаляем все продукты из списка
            while (!productList.isEmpty()) {
                Product removedProduct = productList.removeFirst();
                deletedList.add(removedProduct);
            }

            // Удаляем запись из Map, так как список опустел
            products.remove(name);
            System.out.println("Все экземпляры продукта '" + name + "' удалены из корзины.");
        }

        return deletedList;

    }

    //Печать корзины
    public void printBasket() {
        System.out.println(products);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}