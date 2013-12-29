package com.vijayrc.algos.java.search;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PatternMatch {
    //O(n*m)
    public Integer count(String input, String pattern) {
        int match = 0;
        int n = input.length();
        int p = pattern.length();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == pattern.charAt(0)) {
                for (int j = 0; (i + j) < n && j < p; j++) {
                    if (input.charAt(i + j) != pattern.charAt(j)) break;
                    if (j == (p - 1)) match++;
                }
            }
        }
        return match;
    }

    public static class PatternMatchTest {
        @Test
        public void shouldFindPatternMatch() {
            PatternMatch patternMatch = new PatternMatch();
            assertEquals(new Integer(4), patternMatch.count("ABAABABBAB", "AB"));
            assertEquals(new Integer(3), patternMatch.count("ABAABABBABA", "ABA"));
            assertEquals(new Integer(1), patternMatch.count("ABAABABBABA", "BABA"));
            assertEquals(new Integer(1), patternMatch.count("ABAABABBABA", "ABAABABBABA"));
        }
    }

}
