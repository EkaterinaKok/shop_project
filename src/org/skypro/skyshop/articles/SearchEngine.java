package org.skypro.skyshop.articles;

import java.util.*;

public class SearchEngine {

    private List<Searchable> searchables = new ArrayList<>();
    private int sizeArr;

    public int getSizeArr() {
        return sizeArr;
    }

    public SearchEngine() {

    }

    public Map<String, Searchable> search(String string) {
        Map<String, Searchable> result = new TreeMap<>();
        boolean find = false;

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(string)) {
                String key = searchable.getSearchTerm();
                result.put(key, searchable);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Не найдено элементов!");
        }

        return result;
    }


    public void add(Searchable searchable) {
        if (searchable == null) {
            System.out.println("Невозможно добавить пустой продукт.");
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
