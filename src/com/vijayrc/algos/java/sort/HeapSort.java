package com.vijayrc.algos.java.sort;

import com.vijayrc.algos.java.trees.heap.HeapMaxStrategy;
import com.vijayrc.algos.java.trees.heap.HeapMinStrategy;
import com.vijayrc.algos.java.trees.heap.HeapStrategy;
import com.vijayrc.algos.java.trees.heap.HeapTree;

import java.util.ArrayList;
import java.util.List;

/**
 *Not stable
  O(1) extra space
  O(n�lg(n)) time
  Not really adaptive
 */
public class HeapSort<T extends Comparable> {

    public List<T> desc(List<T> list) {
        HeapMaxStrategy<T> strategy = new HeapMaxStrategy<T>();
        return sort(list, strategy);
    }

    public List<T> asc(List<T> list) {
        HeapMinStrategy<T> strategy = new HeapMinStrategy<T>();
        return sort(list, strategy);
    }

    private List<T> sort(List<T> list, HeapStrategy<T> strategy) {
        HeapTree<T> tree = new HeapTree<T>(strategy);
        for (T t : list) tree.add(t);
        tree.print();

        List<T> sorted = new ArrayList<T>();
        T item;
        while ((item = tree.remove()) != null) sorted.add(item);
        return sorted;
    }
}
