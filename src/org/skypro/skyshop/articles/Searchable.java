package org.skypro.skyshop.articles;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Comparator;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return this.getSearchTerm() + "\n" + this.getContentType();
    }

    public class SearchComporator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthComparison = Integer.compare(
                    s2.getSearchTerm().length(),
                    s1.getSearchTerm().length());

            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return s1.getSearchTerm().compareToIgnoreCase(s2.getSearchTerm());
        }
    }



}
