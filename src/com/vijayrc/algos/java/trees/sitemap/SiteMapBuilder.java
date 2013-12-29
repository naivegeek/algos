package com.vijayrc.algos.java.trees.sitemap;

import com.vijayrc.algos.java.sort.InsertionSort;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;

public class SiteMapBuilder {

    public SiteMapNode on(List<String> urls) {
        new InsertionSort().on(urls);
        SiteMapNode root = new SiteMapNode("/", "/");
        for (String url : urls) {
            root.add(url);
        }
        return root;
    }

    public static class SiteMapBuilderTest {

        private SiteMapBuilder builder;

        @Before
        public void setup(){
            builder = new SiteMapBuilder();
        }

        @Test
        public void shouldWork() {
            List<String> urls = new ArrayList<String>();
            urls.add("/1/11/112");
            urls.add("/1/11/111");
            urls.add("/1/11");
            urls.add("/1");
            urls.add("/1/12/111");
            urls.add("/1/12");
            urls.add("/1/12/112");
            urls.add("/2/22/221");
            urls.add("/2/22");
            urls.add("/2");
            urls.add("/2/21");
            urls.add("/2/21/221");
            urls.add("/2/22/222");
            urls.add("/2/21/222");

            SiteMapNode root = builder.on(urls);
            assertNotNull(root);
            root.print();
        }
    }

}
