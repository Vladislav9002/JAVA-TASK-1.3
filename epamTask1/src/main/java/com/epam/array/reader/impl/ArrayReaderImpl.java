package com.epam.array.reader.impl;

import com.epam.array.exception.ArrayException;
import com.epam.array.reader.ArrayReader;
import com.epam.array.validator.StringArrayValidator;
import com.epam.array.validator.impl.StringArrayValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ArrayReaderImpl implements ArrayReader {

    static final Logger LOGGER = LogManager.getLogger();

    StringArrayValidator validator = new StringArrayValidatorImpl();

    /*@Override
    public List<int[]> readArray(String filename) throws ArrayException {
        File file = new File(filename);

        if (filename == null || (!file.exists()) || file.length() == 0) {
            LOGGER.log(Level.ERROR, "File " + filename + " is empty or null");
            throw new ArrayException("File " + filename + " is empty or null");
        }


        List<String> lines;

        try {
            lines = Files.readAllLines(Paths.get("data\\arrays.txt"), UTF_8);
        } catch (
                IOException e) {
            LOGGER.log(Level.ERROR, "File " + filename + " doesn't have any valid array");
            throw new ArrayException("File " + filename + " doesn't have any valid array");
        }

        List<int[]> arrays = new ArrayList<>();

        for (String line : lines) {

            String[] values = line.split("\\s+");
            ArrayList<Integer> nums = new ArrayList<>();

            for (String val : values) {
                if (validator.stringNumberValidate(val)) {
                    int numericValue = Integer.parseInt(val);
                    nums.add(numericValue);
                    System.out.print(val + " ");
                }
            }
            for(Integer num : nums){
                int[] tempArr = new int[nums.size()];
                tempArr = (int[])nums.toArray(new Integer[0])
            }
        }





        for (int[] a : arrays) {
            System.out.println(a);
        }

        return arrays;
    }*/


    @Override
    public List<int[]> readArray(String filename) throws ArrayException {
        File file = new File(filename);

        if (filename == null || (!file.exists()) || file.length() == 0) {
            LOGGER.log(Level.ERROR, "File " + filename + " is empty or null");
            throw new ArrayException("File " + filename + " is empty or null");
        }

        List<String> lines;

        try {
            lines = Files.readAllLines(Paths.get("data\\arrays.txt"), UTF_8);
        } catch (
                IOException e) {
            LOGGER.log(Level.ERROR, "File " + filename + " doesn't have any valid array");
            throw new ArrayException("File " + filename + " doesn't have any valid array");
        }

        List<int[]> mainList = new ArrayList<>();


        for (String line : lines) {
            String[] values = line.split("\\s+");
            List<Integer> tempList = new ArrayList<>();

            for (String val : values) {
                if (validator.stringNumberValidate(val)) {
                    int numericValue = Integer.parseInt(val);
                    tempList.add(numericValue);
                }
            }


            int[] tempArr = new int[tempList.size()];
            for (int i = 0; i < tempList.size(); i++) {
                tempArr[i] = tempList.get(i);
            }
            mainList.add(tempArr);

        }


        return mainList;
    }
}