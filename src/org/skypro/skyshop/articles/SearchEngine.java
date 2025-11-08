package org.skypro.skyshop.articles;

public class SearchEngine {

    private Searchable[] searchables;
    private int sizeArr;

    public Searchable[] getSearchables() {
        return searchables;
    }

    public int getSizeArr() {
        return sizeArr;
    }

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String string) {
        Searchable[] searcha = new Searchable[5];
        int count = 0;
        boolean find = false;

        for (int i = 0; i < searchables.length - 1; i++) {
            if (searchables[i].getSearchTerm().contains(string) && count < 5) {
                searcha[count] = searchables[i];
                find = true;
                count++;
            }
            if (count >= 5) break;
        }
        if (count == 0 && find == false) System.out.println("Не найдено элементов!");
        return searcha;
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            System.out.println("Невозможно добавить пустой продукт.");
            return;
        }

        if (sizeArr >= searchables.length) {
            System.out.println("Корзина заполнена. Невозможно добавить продукт.");
            return;
        } else {
            searchables[sizeArr] = searchable;
            sizeArr++;
        }
    }

    public Searchable searchSearchable(String string) {
        String substring = string;
        int countMax = 0;
        Searchable bestResult = null;

        for (Searchable searchable : searchables) {
            int count = 0;
            int index = 0;
            String str = searchable.getSearchTerm();
            int indexSubstring = str.indexOf(substring, index);

            while (indexSubstring != -1) {
                count++;
                index = indexSubstring + substring.length();
                indexSubstring = str.indexOf(substring, index);
                if (count > countMax) {
                    countMax = count;
                    bestResult = searchable;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound();
        }
        return bestResult;
    }

}
