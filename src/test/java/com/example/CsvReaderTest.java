package com.example;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by timcarl on 4/9/2016.
 */
public class CsvReaderTest {

    @Test
    public void testGetData() throws Exception {

        CsvReader reader = new CsvReader("TestData/data.csv");

        assertNotNull(reader);

        Map<String, List<Integer>> data = reader.getData();

        assertNotNull(data);
        assertEquals(3, data.entrySet().size());
    }
}
