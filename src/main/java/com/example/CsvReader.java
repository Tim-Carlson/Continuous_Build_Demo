package com.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timcarl on 4/9/2016.
 */
public class CsvReader implements IReader {
    private String mFileName;

    public CsvReader(String fileName) {
        mFileName = fileName;
    }

    @Override
    public Map<String, List<Integer>> getData() {

        HashMap<String, List<Integer>> data = new HashMap<String, List<Integer>>();

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(mFileName));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] dataStrings = line.split(cvsSplitBy);
                List<Integer> seriesData = new ArrayList<Integer>();
                for(String s : dataStrings) {
                    try {
                        seriesData.add(Integer.parseInt(s.trim()));
                    } catch (NumberFormatException ex) {
                    }
                }
                data.put(dataStrings[0], seriesData);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");


        return data;

    }


}
