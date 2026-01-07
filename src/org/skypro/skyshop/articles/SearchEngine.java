package org.skypro.skyshop.articles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searchables = new ArrayList<>();
    //private Searchable[] searchables;
    private int sizeArr;

    public List<Searchable> getSearchables() {
        return searchables;
    }

    public int getSizeArr() {
        return sizeArr;
    }

    public SearchEngine() {

    }

    public List<Searchable> search(String string) {
        List<Searchable> searcha = new LinkedList<>();
        int count = 0;
        boolean find = false;

        for (Searchable searсh: searchables) {
            if (searсh.getSearchTerm().contains(string)) {
                searcha.add(searсh);
                find = true;
                count++;
            }
        }
        if (count == 0 && find == false) System.out.println("Не найдено элементов!");
        return searcha;
    }

    public void add(Searchable searchable) {
        if (searchable == null) {
            System.out.println("Невозможно добавить пустой продукт.");
            return;
        } else {
            searchables.add(searchable);
            sizeArr++;
        }
    }

    public Searchable searchSearchable(String string) throws BestResultNotFound {
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
