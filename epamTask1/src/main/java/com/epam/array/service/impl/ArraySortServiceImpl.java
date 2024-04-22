package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.ArrayException;
import com.epam.array.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.logging.Level;


public class ArraySortServiceImpl implements ArraySortService {

    static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void sortSelection(CustomArray array) throws ArrayException {

        if (array.length() < 1) {
            LOGGER.error("The array is empty");
            throw new ArrayException("this array is empty");
        }


        int[] tempArray = array.getArray();
        for (int left = 0; left < tempArray.length; left++) {
            int min = left;
            for (int i = left; i < tempArray.length; i++) {
                if (tempArray[i] < tempArray[min]) {
                    min = i;
                }
            }
            int t = tempArray[left];
            tempArray[left] = tempArray[min];
            tempArray[min] = t;
        }


        array.setArray(tempArray);

        LOGGER.info( "The sorted array: "
                + Arrays.toString(array.getArray())
                + " (sortSelection)");

    }


    @Override
    public void sortInsertion(CustomArray array) throws ArrayException {

        if (array.length() < 1) {
            LOGGER.error("The array is empty");
            throw new ArrayException("this array is empty");
        }


        int[] tempArray = array.getArray();

        for (int left = 0; left < tempArray.length; left++) {
            int value = tempArray[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < tempArray[i]) {
                    tempArray[i + 1] = tempArray[i];
                } else {
                    break;
                }
            }
            tempArray[i + 1] = value;
        }


        array.setArray(tempArray);

        LOGGER.info( "The sorted array: "
                + Arrays.toString(array.getArray())
                + " (sortSelection)");
    }

}
