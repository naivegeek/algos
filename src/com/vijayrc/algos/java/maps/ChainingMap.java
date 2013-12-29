package com.vijayrc.algos.java.maps;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChainingMap<K, T> {
    private List<Bucket> buckets = new ArrayList<Bucket>();

    public void put(K key, T value) {
        Bucket bucket = new Bucket(key.hashCode());
        if (buckets.contains(bucket)) {
            buckets.get(buckets.indexOf(bucket)).add(key, value);
        } else {
            bucket.add(key, value);
            buckets.add(bucket);
        }
    }

    public T find(K key) {
        Bucket bucket = new Bucket(key.hashCode());
        if (!buckets.contains(bucket)) return null;
        bucket = buckets.get(buckets.indexOf(bucket));
        return (T) bucket.find(key);
    }

    public static class ChainingMapTest {
        private ChainingMap<String, String> map;
        @Before
        public void setup() { map = new ChainingMap<>(); }
        @Test
        public void shouldWork() {
            map.put("C1","Kenny");
            map.put("C2","Kyle");
            map.put("C3","Cartman");
            map.put("C4","Butters");
            assertEquals("Kenny",map.find("C1"));
            map.put("C1","Token");
            assertEquals("Token",map.find("C1"));
        }
    }

}
