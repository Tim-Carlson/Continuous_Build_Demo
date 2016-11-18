package com.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Created by timcarl on 4/9/2016.
 */
public class JPEGChartRenderer {

    private String mFileName;
    public JPEGChartRenderer(String fileName) {
        mFileName = fileName;
    }


    public void createChart(Map<String, List<Integer>> dataSet) {
        DefaultCategoryDataset lineChartDataset = new DefaultCategoryDataset();
        for (Map.Entry<String, List<Integer>> entry : dataSet.entrySet()) {
            int j = 1;
            for(Integer i : entry.getValue()) {
                lineChartDataset.addValue(i, entry.getKey(), Integer.toString(j++));
            }
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Example Graph","Data point",
                "Value",
                lineChartDataset,PlotOrientation.VERTICAL,
                true,true,false);

        int width = 800; /* Width of the image */
        int height = 600; /* Height of the image */
        File lineChart = new File( mFileName );
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
