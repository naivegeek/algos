package com.vijayrc.algos.java.trees.heap;

public interface HeapStrategy<T extends Comparable> {
    void balance(HeapNode node);
}
