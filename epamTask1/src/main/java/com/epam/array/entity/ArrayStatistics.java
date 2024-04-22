package com.epam.array.entity;

import com.epam.array.service.ArrayService;
import com.epam.array.service.impl.ArrayServiceImpl;

public class ArrayStatistics {
    ArrayService service = new ArrayServiceImpl();

    private int sum;
    private int min;
    private int max;
    private double average;
    private int numMinus;

    public ArrayStatistics(CustomArray array) {
        this.sum = service.findSum(array);
        this.min = service.findMin(array);
        this.max = service.findMax(array);
        this.average = service.findAverage(array);
        this.numMinus = service.findNumMinus(array);
    }
}
