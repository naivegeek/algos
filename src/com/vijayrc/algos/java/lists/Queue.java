package com.vijayrc.algos.java.lists;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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

    public class QueueTest {
        @Test
        public void shouldWork() {
            Queue<String> q = new Queue<String>();
            q.put("A");
            q.put("B");
            q.put("C");
            assertEquals("A",q.get());
            assertEquals("B",q.get());
            assertEquals("C",q.get());
        }
    }


}
