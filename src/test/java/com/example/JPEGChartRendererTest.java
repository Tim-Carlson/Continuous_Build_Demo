package com.example;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by timcarl on 4/9/2016.
 */
public class JPEGChartRendererTest {

    private String outFile = "output.jpeg";

    @Before
    public void setUp() throws Exception {
        File outfile = new File(outFile);

        if(outfile.exists()) {
            outfile.delete();
        }

    }

    @Test
    public void testCreateChart() throws Exception {

        JPEGChartRenderer renderer = new JPEGChartRenderer(outFile);
        assertNotNull(renderer);

        HashMap<String, List<Integer>> data = new HashMap<String, List<Integer>>();

        data.put("New Series", Arrays.asList(new Integer(5), new Integer(10), new Integer(11)));
        File outfile = new File(outFile);

        assertFalse(outfile.exists());
        renderer.createChart(data);
        assertTrue(outfile.exists());

    }
}