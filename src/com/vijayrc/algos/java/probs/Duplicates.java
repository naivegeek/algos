package com.vijayrc.algos.java.probs;

import com.vijayrc.algos.java.sort.InsertionSort;
import java.util.List;

public class Duplicates<T extends Comparable> {
    public void on(List<T> input) {
        new InsertionSort<T>().on(input);
        for (int j = input.size() - 1; j > 0; j--)
            if (input.get(j).compareTo(input.get(j - 1)) == 0)
                input.remove(j);
    }
    public void on2(List<T> input) {
        for (int i = input.size() - 1; i >= 0; i--)
            for (int j = i - 1; j >= 0; j--)
                if (input.get(j).compareTo(input.get(i)) == 0) { input.remove(i); break; }
    }
}
