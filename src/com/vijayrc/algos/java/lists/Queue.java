package com.vijayrc.algos.java.lists;

public class Queue<T extends Object> {
    private Node<T> head;
    private Node<T> tail;

    public void put(T t) {
        Node<T> node = new Node<T>(t);
        if (head == null) {
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public T get() {
        Node<T> toDequeue = head;
        if (head != null) {
            head = head.next;
            return toDequeue.value();
        }
        return null;
    }

    public boolean isEmpty(){
        return head == null;
    }

}
