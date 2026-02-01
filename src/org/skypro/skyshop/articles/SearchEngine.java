package org.skypro.skyshop.articles;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    private HashSet<Searchable> searchables = new HashSet<>();
    private int sizeArr;

    public int getSizeArr() {
        return sizeArr;
    }

    public SearchEngine() {
    }


    public Set<Searchable> search(String string) {
        Set<Searchable> result = searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(string.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new Searchable.SearchComporator())));

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

    @Override
    public String toString() {
        return searchables.toString();
    }
}
