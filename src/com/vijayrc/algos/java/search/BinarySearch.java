package com.vijayrc.algos.java.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 *
 * O(log(n) - base 2)
 */
public class BinarySearch<T extends Comparable> {

    public Integer find(T t, List<T> input) {
        return realFind(t, input, 0, input.size() - 1);
    }

    private Integer realFind(T t, List<T> input, int start, int end) {
        if (t.compareTo(input.get(start)) == 0) return start;
        if (t.compareTo(input.get(end)) == 0) return end;

        int mid = (end + start) / 2;
        int compare = t.compareTo(input.get(mid));
        if (compare < 0) return realFind(t, input, start, mid);
        if (compare == 0) return mid;
        if (compare > 0) return realFind(t, input, mid + 1, end);
        return -1;
    }

    public static class BinarySearchTest {

        @Test
        public void shouldWork() {
            BinarySearch<String> bs = new BinarySearch<String>();
            assertEquals(new Integer(1), bs.find("B", Arrays.asList("A", "B", "C", "D")));
            assertEquals(new Integer(2), bs.find("C", Arrays.asList("A", "B", "C", "D")));
            assertEquals(new Integer(3), bs.find("D", Arrays.asList("A", "B", "C", "D")));
            assertEquals(new Integer(0), bs.find("A", Arrays.asList("A", "B", "C", "D")));
        }
    }

}
