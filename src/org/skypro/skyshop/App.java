package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //Создали несколько продуктов
        Product product1 = new SimpleProduct("Огурец", 50);
        Product product2 = new SimpleProduct("Яблоко", 100);
        Product product3 = new SimpleProduct("Лук", 30);
        Product discountedProduct1 = new DiscountedProduct("Лимон", 60, 20);
        Product discountedProduct2 = new DiscountedProduct("Перец", 150, 20);
        Product fixPriceProduct1 = new FixPriceProduct("Шоколад");
        Product fixPriceProduct2 = new FixPriceProduct("Печенье");

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

        //ДЗ по разделу ООП: полиморфизм и интерфейсы
        SearchEngine searchEngine = new SearchEngine(11);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(discountedProduct1);
        searchEngine.add(discountedProduct2);
        searchEngine.add(fixPriceProduct1);
        searchEngine.add(fixPriceProduct2);

        Searchable article1 = new Article("Заголовок 1", "Интересный текст");
        Searchable article2 = new Article("Заголовок 2", "Важный текст");
        Searchable article3 = new Article("Заголовок 3", "Короткий текст");
        Searchable article4 = new Article("Заголовок 4", "Длинный текст");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        System.out.println("\nВывод нового элеманта статья и ее текст:");
        System.out.println(article1.getStringRepresentation());

        System.out.println("\nВывод продукта через новый элемент:");
        System.out.println(product1.getStringRepresentation());
        System.out.println(discountedProduct1.getStringRepresentation());
        System.out.println(fixPriceProduct1.getStringRepresentation());

        System.out.println("\nКоличество элементов в массиве: " + searchEngine.getSizeArr());

        System.out.println("\nВывод полученного массива из поиска:");
        Searchable[] searcha1 = searchEngine.search("Лимон");
        System.out.println(Arrays.toString(searcha1));
        Searchable[] searcha2 = searchEngine.search("Огурец");
        System.out.println(Arrays.toString(searcha2));
        Searchable[] searcha3 = searchEngine.search("Шоколад");
        System.out.println(Arrays.toString(searcha3));
        Searchable[] searcha4 = searchEngine.search("Заголовок 1");
        System.out.println(Arrays.toString(searcha4));
        Searchable[] searcha5 = searchEngine.search("Неизвестный текст");
        System.out.println(Arrays.toString(searcha5));

        SearchEngine testSearch = new SearchEngine(10);
        testSearch.add(product1);
        testSearch.add(product2);
        testSearch.add(product3);
        testSearch.add(product1);
        testSearch.add(product2);
        testSearch.add(product3);
        testSearch.add(product1);  // Огурцов 6, выведет 5
        testSearch.add(product1);
        testSearch.add(product1);
        testSearch.add(product1);

        System.out.println("\nТест на количество в массиве searh:");
        Searchable[] test1 = testSearch.search("Огурец");
        System.out.println(Arrays.toString(test1));

    }
}