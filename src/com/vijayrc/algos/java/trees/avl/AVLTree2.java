package com.vijayrc.algos.java.trees.avl;


import com.vijayrc.algos.java.trees.nodes.Node;

public class AVLTree2<T extends Comparable> {

    private Node<T> root = new Node<T>();

    public void insert(T t) {
        root.insert(t);
        root.balance();
    }

    public void print() {
        root.print();
    }
}
