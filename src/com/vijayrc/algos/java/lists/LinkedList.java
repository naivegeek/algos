package com.vijayrc.algos.java.lists;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LinkedList<T extends Object> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
    }

    public void add(T t) {
        Node<T> item = new Node<T>(t);
        if (head == null) {
            head = item;
            tail = head;
            return;
        }
        tail.next = item;
        tail = item;
    }

    public void remove(T t) {
        Node<T> toRemove = new Node<T>(t);
        if (toRemove.equals(head)) head = head.next;
        for (Node<T> node = head; node != null;) {
            if (toRemove.equals(node.next)) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
    }

    public Integer size() {
        int count = 0;
        for (Node<T> node = head; node != null;) {
            count++;
            node = node.next;
        }
        return count;
    }
    public static class LinkedListTest {

        private LinkedList<String> list;

        @Before
        public void setup() {
            list = new LinkedList<String>();
        }

        @Test
        public void shouldAddItem() {
            list.add("Cartman");
            list.add("Kyle");
            list.add("Kenny");
            assertEquals(new Integer(3), list.size());
        }

        @Test
        public void shouldRemoveItem() {
            list.add("Cartman");
            list.add("Kyle");
            list.add("Kenny");

            list.remove("Kyle");
            assertEquals(new Integer(2), list.size());

            list.add("Jimmy");
            list.add("Butters");

            list.remove("Cartman");
            assertEquals(new Integer(3), list.size());
            list.remove("Butters");
            assertEquals(new Integer(2), list.size());

        }
    }


}
