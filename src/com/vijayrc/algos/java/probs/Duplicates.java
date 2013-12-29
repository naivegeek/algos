package com.vijayrc.algos.java.probs;

import com.vijayrc.algos.java.sort.InsertionSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class Duplicates<T extends Comparable> {
    public void on(List<T> input) {
        new InsertionSort<T>().on(input);
        for (int j = input.size() - 1; j > 0; j--)
            if (input.get(j).compareTo(input.get(j - 1)) == 0)
                input.remove(j);
    }
    public void on2(List<T> input) {
        for (int i = input.size() - 1; i >= 0; i--)
            for (int j = i - 1; j >= 0; j--)
                if (input.get(j).compareTo(input.get(i)) == 0) { input.remove(i); break; }
    }

    public class DuplicateTest {
        Duplicates<String> remover = new Duplicates<String>();

        @Test
        public void shouldWorkWithSort() {
            List<String> actual = new ArrayList<String>();
            actual.addAll(Arrays.asList("A", "A", "B", "C", "X", "C", "B"));
            List<String> expected = new ArrayList<String>();
            expected.addAll(Arrays.asList("A", "B", "C", "X"));
            remover.on(actual);
            assertEquals(expected, actual);
        }

        @Test
        public void shouldWorkWithoutSort() {
            List<String> actual = new ArrayList<String>();
            actual.addAll(Arrays.asList("A", "A", "B", "C", "X", "C", "B"));
            List<String> expected = new ArrayList<String>();
            expected.addAll(Arrays.asList("A", "B", "C", "X"));
            remover.on2(actual);
            assertEquals(expected, actual);
        }

    }
}
