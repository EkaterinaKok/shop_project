package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        //Создали несколько продуктов
        Product product1 = new SimpleProduct("Огурец", 50);
        Product product2 = new SimpleProduct("Яблоко", 100);
        Product product3 = new SimpleProduct("Лук", 30);
        Product discountedProduct1 = new DiscountedProduct("Лимон", 60,20);
        Product discountedProduct2 = new DiscountedProduct("Перец", 150,20);
        Product fixPriceProduct1 = new FixPriceProduct("Шоколад", 50);
        Product fixPriceProduct2 = new FixPriceProduct("Печенье", 50);

//Корзина для проверки ДЗ по абстракции!
        System.out.println("\nКорзина:");
        ProductBasket basketAbstraction = new ProductBasket();
        basketAbstraction.addProduct(discountedProduct1);
        basketAbstraction.addProduct(product1);
        basketAbstraction.addProduct(fixPriceProduct1);
        basketAbstraction.addProduct(product2);
        basketAbstraction.addProduct(product3);
        basketAbstraction.print();

        //Создали корзину
        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        //1. Добаавили в 1 корзину 5 продуктов
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
        basket1.print();

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
        basket1.printTotal();

        //10. Поиск товара по имени в пустой корзине.
        System.out.println("\nПоиск товара по имени в пустой корзине:");
        basket1.productSearch("Лук");
    }
}