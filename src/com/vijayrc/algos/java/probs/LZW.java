package com.vijayrc.algos.java.probs;

import java.util.*;
import com.vijayrc.algos.java.lists.Queue;

/**
 * BABAABAZBABAABAZ
 *
 */
public class LZW {
    private Map<Integer, String> table = new HashMap<Integer, String>();
    private List<Integer> codes = new ArrayList<Integer>();

    public void compress(String input) {
        int code = 1;
        int length = input.length();

        Queue<String> queue = new Queue<>();
        for (int i = 0; i < length; i++)
            queue.put(input.charAt(i) + "");

        String p = queue.get();
        while (!queue.isEmpty()) {
            String c = queue.get();
            if (table.containsValue(p + c)) {
                p = p + c;
            } else {
                table.put(code, p + c);
                codes.add(getCode(p));
                code++;
                p = c;
            }
        }
    }
    private Integer getCode(String p) {
        return null;
    }
    public List<Integer> codes() {
        return codes;
    }

}
