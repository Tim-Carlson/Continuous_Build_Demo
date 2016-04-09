package com.example;

import java.util.List;
import java.util.Map;

/**
 * Created by timcarl on 4/9/2016.
 */
public class Main {

    public static void main(String[] args) {

        CsvReader reader = new CsvReader(args[0]);

        Map<String, List<Integer>> data = reader.getData();


        JPEGChartRenderer renderer = new JPEGChartRenderer("Chart.jpeg");

        renderer.createChart(data);

    }
}
