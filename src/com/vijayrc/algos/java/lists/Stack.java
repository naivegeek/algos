package com.vijayrc.algos.java.lists;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Stack<T extends Object> {
    private Node<T> tail;

    public void push(T t) {
        Node<T> node = new Node<T>(t);
        node.next = tail;
        tail = node;
    }

    public T pop() {
        Node<T> toPop = tail;
        if (tail != null) {
            tail = tail.next;
            return toPop.value();
        }
        return null;
    }

    public static class StackTest {

        @Test
        public void shouldWork() {
            Stack<String> stack = new Stack<String>();
            stack.push("A");
            stack.push("B");
            stack.push("C");
            assertEquals("C",stack.pop());
            assertEquals("B",stack.pop());
            assertEquals("A",stack.pop());
        }
    }


}
