package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.service.ArrayService;

import java.util.Arrays;

public class ArrayServiceStreamImpl implements ArrayService {

    @Override
    public int findMax(CustomArray array) {
        return Arrays.stream(array.getArray()).max().getAsInt();
    }

    @Override
    public int findMin(CustomArray array) {
        return Arrays.stream(array.getArray()).min().getAsInt();
    }

    @Override
    public double findAverage(CustomArray array) {
        return Arrays.stream(array.getArray()).average().getAsDouble();
    }


    @Override
    public int findSum(CustomArray array) {
        return Arrays.stream(array.getArray()).sum();

    }

    @Override
    public int findNumMinus(CustomArray array) {
        return (int)Arrays.stream(array.getArray()).filter(n -> n< 1).count();
    }

    @Override
    public void replaceElement(CustomArray array, int el, int index) {
        return;
    }
}
