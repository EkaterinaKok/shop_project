package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        //Создали несколько продуктов
        Product product1 = new Product("Огурец", 50);
        Product product2 = new Product("Яблоко", 100);
        Product product3 = new Product("Лук", 30);

        //Создали корзину
        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        //1. Добаавили в корзину 5 продуктов в 1 корзину
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product1);
        basket1.addProduct(product2);

        // вторая корзина
        basket2.addProduct(product2);
        basket2.addProduct(product3);


        //2. Добавление продукта в заполненную корзину, в которой нет свободного места.
        System.out.println("\nОбработка ошибки на заполненную корзину:");
        basket1.addProduct(product3);

        //3. Печать содержимого корзины с несколькими товарами.
        System.out.println("\nСодержимое корзины №2:");
        basket2.print();

        //4. Получение стоимости корзины с несколькими товарами.
        System.out.println("\nСтоимость корзины №1:");
        basket1.printTotal();

        //5. Поиск товара, который есть в корзине.
        System.out.println("\nПоиск товара, который есть в корзине:");
        basket1.productSearch("Лук");

        //6. Поиск товара, которого нет в корзине.
        System.out.println("\nПоиск товара, которого нет в корзине:");
        basket1.productSearch("Тыква");

        System.out.println("\nОчистка корзин №1 и №2:");
        //7. Очистка корзины
        basket1.clearArr();
        basket2.clearArr();

        //8. Печать пустой корзины
        basket1.print();
        basket2.print();

        //9. Получение стоимости пустой корзины.
        System.out.println("\nПолучение стоимости пустой корзины:");
        basket1.total();

        //10. Поиск товара по имени в пустой корзине.
        System.out.println("\nПоиск товара по имени в пустой корзине:");
        basket1.productSearch("Лук");
    }
}