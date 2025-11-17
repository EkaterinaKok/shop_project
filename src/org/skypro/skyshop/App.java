package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.BestResultNotFound;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        SearchEngine searchEngine = new SearchEngine();
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
        List<Searchable> searcha1 = searchEngine.search("Лимон");
        System.out.println(searcha1);
        List<Searchable> searcha2 = searchEngine.search("Огурец");
        System.out.println(searcha2);
        List<Searchable> searcha3 = searchEngine.search("Шоколад");
        System.out.println(searcha3);
        List<Searchable> searcha4 = searchEngine.search("Заголовок 1");
        System.out.println(searcha4);
        List<Searchable> searcha5 = searchEngine.search("Неизвестный текст");
        System.out.println(searcha5);

        SearchEngine testSearch = new SearchEngine();
        testSearch.add(product1);
        testSearch.add(product2);
        testSearch.add(product3);
        testSearch.add(product1);
        testSearch.add(product2);
        testSearch.add(product3);
        testSearch.add(product1);  // Огурцов 6
        testSearch.add(product1);
        testSearch.add(product1);
        testSearch.add(product1);

        System.out.println("\nТест на количество в массиве searh:");
        List<Searchable> test1 = testSearch.search("Огурец");
        System.out.println("Список найденных продуктов: " + test1);

//        Проверка для ДЗ по исключениям
// 2. Демонстрация проверки данных в классе main
        System.out.println("\nПРОВЕРКА ДЗ ПО ИСКЛЮЧЕНИЯМ:");
        try {
            Product product4 = new SimpleProduct("", 10);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            Product product5 = new SimpleProduct("   ", 20);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            Product product6 = new SimpleProduct(null, 30);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            Product product7 = new SimpleProduct("Икра", -5);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            Product product8 = new SimpleProduct("Кетчуп", 0);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            Product discountedProduct3 = new DiscountedProduct("Кукуруза", 0, 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product discountedProduct4 = new DiscountedProduct("Кукуруза", 100, 110);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
// 3. Реализация метода поиска самого подходящего элемента
        System.out.println("\nВернуть объект,где максимальное количество вхождений подстроки:");
        Searchable article5 = new Article("Скорее", "Беги, беги скорее, беги без оглядки!");
        Searchable article6 = new Article("Без оглядки", "Беги, беги скорее, без оглядки!");
        Searchable article7 = new Article("Беги", "Беги, беги, беги скорее, беги без оглядки!");
        SearchEngine searchEngineTest = new SearchEngine();
        searchEngineTest.add(article5);
        searchEngineTest.add(article6);
        searchEngineTest.add(article7);

// 5. Демонстрация нового метода поиска
        try {
            System.out.println(searchEngineTest.searchSearchable("беги"));
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }

        try {
            System.out.println(searchEngineTest.searchSearchable("курица"));
        } catch (BestResultNotFound b) {
            System.out.println(b.getMessage());
        }
// Работа с коллекциями
        System.out.println("\nРАБОТА С КОЛЛЕКЦИЯМИ");
        System.out.println("Первоначальная корзина:");
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.printBasket();
        //удаление существующего продукта
        System.out.println("\nСписок удаленных элементов: " + basket1.deleteProduct("Огурец"));
        System.out.println("\nКорзина после удаления элементов поиска:");
        basket1.printBasket();
        //удаление несуществующего продукта
        basket1.deleteProduct("Нет такого продукта");
        System.out.println("\nПечать корзины:");
        basket1.printBasket();

    }

}