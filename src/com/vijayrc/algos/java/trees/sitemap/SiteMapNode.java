package com.vijayrc.algos.java.trees.sitemap;

import com.vijayrc.algos.java.utilities.Print;
import com.vijayrc.algos.java.utilities.Printable;

import java.util.*;
import com.vijayrc.algos.java.lists.Queue;

public class SiteMapNode implements Printable {
    private String url;
    private String value;
    private Map<String, SiteMapNode> children = new HashMap<String, SiteMapNode>();

    public SiteMapNode(String url, String value) {
        this.url = url;
        this.value = value;
    }

    public void add(String url) {
        String[] splits = url.split("/");
        Queue<String> tokens = new Queue<>();
        for (int i = 1; i < splits.length; i++) tokens.put(splits[i]);
        recurse(tokens, url);
    }

    public void recurse(Queue<String> tokens, String url) {
        if (tokens.isEmpty()) return;
        String key = tokens.get();
        if (!children.containsKey(key))children.put(key, new SiteMapNode(url, key));
        children.get(key).recurse(tokens, url);
    }

    public List<Printable> printables() {
        return new ArrayList<Printable>(children.values());
    }

    public void print() {
        new Print().with(this);
    }

    @Override
    public String toString() {
        return value+"=>"+url;
    }
}
