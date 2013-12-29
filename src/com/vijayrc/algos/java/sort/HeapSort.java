package com.vijayrc.algos.java.sort;

import com.vijayrc.algos.java.trees.heap.HeapMaxStrategy;
import com.vijayrc.algos.java.trees.heap.HeapMinStrategy;
import com.vijayrc.algos.java.trees.heap.HeapStrategy;
import com.vijayrc.algos.java.trees.heap.HeapTree;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

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

    public static class HeapSortTest {
        private HeapSort<Integer> sort;

        @Before
        public void setup() {
            sort = new HeapSort<Integer>();
        }

        @Test
        public void shouldWork() {
            List<Integer> input = Arrays.asList(1, 5, 7, 8, 3, 4, 2, 6, 9, 11, 12, 10);
            assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), sort.asc(input));
            assertEquals(Arrays.asList(12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1), sort.desc(input));
        }
    }

}
