package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.*;

public class ArrayServiceImplTest {



    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    void findMinPositive() {
        int[] a = {3, 2, 5};
        CustomArray customArray = new CustomArray(a);
        ArrayServiceImpl service = new ArrayServiceImpl();
        int actual = service.findMin(customArray);
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void findMax() {
        int[] a = {3, 2, 5};
        CustomArray customArray = new CustomArray(a);
        ArrayServiceImpl service = new ArrayServiceImpl();
        int actual = service.findMax(customArray);
        int expected = 5;

        Assert.assertEquals(expected, actual);
    }


    @Test
    void findAverage() {

        int[] a = {3, 2, 5};
        CustomArray customArray = new CustomArray(a);
        ArrayServiceImpl service = new ArrayServiceImpl();
        double actual = service.findAverage(customArray);
        double expected = 10 / 3.;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void findSum() {
        int[] a = {3, 2, 5};
        CustomArray customArray = new CustomArray(a);
        ArrayServiceImpl service = new ArrayServiceImpl();
        int actual = service.findSum(customArray);
        int expected = 10;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void findNumMinus() {
        int[] a = {3, 2, 5, -1, -1};
        CustomArray customArray = new CustomArray(a);
        ArrayServiceImpl service = new ArrayServiceImpl();
        int actual = service.findNumMinus(customArray);
        int expected = 2;

        Assert.assertEquals(expected, actual);

    }

    @Test
    void replaceElement() throws ArrayException {
        int[] a = {3, 2, 5, 4, 7};
        CustomArray customArray = new CustomArray(a);
        ArrayServiceImpl service = new ArrayServiceImpl();
        service.replaceElement(customArray, 2, 2);

        int[] actual = customArray.getArray();
        int[] expected = {3, 2, 2, 4, 7};

        Assert.assertEquals(expected, actual);
    }


}
