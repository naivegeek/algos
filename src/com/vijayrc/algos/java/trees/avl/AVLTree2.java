package com.vijayrc.algos.java.trees.avl;


import com.vijayrc.algos.java.trees.nodes.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AVLTree2<T extends Comparable> {

    private Node<T> root = new Node<T>();

    public void insert(T t) {
        root.insert(t);
        root.balance();
    }

    public void print() {
        root.print();
    }

    public static class AVLTree2Test {
        private AVLTree2<Integer> tree;

        @Before
        public void setUp() {
            tree = new AVLTree2<Integer>();
        }

        @Test
        public void shouldBalanceForRandomInput() {
            List<Integer> nos = Arrays.asList(1, 6, 3, 5, 8, 4, 2, 7, 10, 9, 8);
            for (Integer no : nos) {
                tree.insert(no);
            }
            tree.print();
        }

        @Test
        public void shouldNotBalanceForSortedInput() {
            for (int i = 0; i < 20; i++) {
                tree.insert(i);
            }
            tree.print();
        }
    }

}
