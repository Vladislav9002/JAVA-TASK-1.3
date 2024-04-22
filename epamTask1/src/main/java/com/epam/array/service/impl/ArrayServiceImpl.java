package com.epam.array.service.impl;

import com.epam.array.service.ArrayService;
import com.epam.array.entity.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArrayServiceImpl implements ArrayService {

    static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int findMax(CustomArray array) {


        int max = array.getElement(0);
        for (int i = 0; i < array.length(); i++) {
            if (array.getElement(i) > max) {
                max = array.getElement(i);
            }
        }
        LOGGER.log(Level.INFO, "The max is " + max);
        return max;
    }

    @Override
    public int findMin(CustomArray array) {
        int min = array.getElement(0);
        for (int i = 0; i < array.length(); i++) {
            if (array.getElement(i) < min) {
                min = array.getElement(i);
            }
        }
        LOGGER.log(Level.INFO, "The min is " + min);
        return min;
    }

    @Override
    public double findAverage(CustomArray array) {
        double average = 0;
        if (array.length() != 0) {
            double sum = 0;
            for (int i = 0; i < array.length(); i++) {
                sum += array.getElement(i);
            }
            average = sum / array.length();
        }
        LOGGER.log(Level.INFO, "The average is " + average);
        return average;
    }

    @Override
    public int findSum(CustomArray array) {
        int sum = 0;
        for (int i = 0; i < array.length(); i++) {
            sum += array.getElement(i);
        }
        LOGGER.log(Level.INFO, "The sum is " + sum);
        return sum;
    }

    @Override
    public int findNumMinus(CustomArray array) {
        int minusNum = 0;
        for (int i = 0; i < array.length(); i++) {
            if (array.getElement(i) < 0) {
                minusNum += 1;
            }
        }

        LOGGER.log(Level.INFO, "The minusNum is " + minusNum);
        return minusNum;
    }

    @Override
    public void replaceElement(CustomArray array, int el, int index) {
        int[] tempArray = array.getArray();

        for (int i = 0; i < array.length(); i++) {
            if (i != index) {
                tempArray[i] = array.getElement(i);
            } else {
                tempArray[i] = el;
            }
        }
        LOGGER.log(Level.INFO, "element was replaced");

        array.setArray(tempArray);
    }


}
