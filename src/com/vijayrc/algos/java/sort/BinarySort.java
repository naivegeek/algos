package com.vijayrc.algos.java.sort;

import com.vijayrc.algos.java.trees.binary.BinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 *
 * O(n�lg(n)) time
 */
public class BinarySort<T extends Comparable> {
    private BinaryTree<T> tree;

    public void on(List<T> list){
        tree = new BinaryTree<T>();
        for (T t : list) {
           tree.insert(t);
        }
    }

    public String inOrder() {
        return tree.inOrder();
    }

    public void print() {
        tree.print();
    }

    public static class BinarySortTest {
        private BinarySort<Integer> heap;

        @Before
        public void setup() {
            heap = new BinarySort<Integer>();
        }

        @Test
        public void shouldWork() {
            heap.on(Arrays.asList(1, 6, 3, 5, 8, 4, 2, 9, 7));
            heap.print();
            assertEquals("123456789", heap.inOrder());

            heap.on(Arrays.asList(4, 6, 3, 5, 8, 1, 2, 9, 7));
            heap.print();
            assertEquals("123456789", heap.inOrder());
        }
    }

}
