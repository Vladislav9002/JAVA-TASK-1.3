package com.epam.array.service.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.ArrayException;
import com.epam.array.service.ArraySortService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArraySortServiceImplTest {

    static int[] array = {3, 7, 2, 1, 8};
    CustomArray customArray = new CustomArray(array);
    ArraySortService sortService = new ArraySortServiceImpl();

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
        this.customArray = new CustomArray(array);
    }

    @Test
    public void testSortSelectionPositive() throws ArrayException {

        sortService.sortSelection(customArray);
        int[] actual = customArray.getArray();
        int[] expected = {1, 2, 3, 7, 8};
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSortInsertionPositive() throws ArrayException {
        sortService.sortInsertion(customArray);
        int[] actual = customArray.getArray();
        int[] expected = {1, 2, 3, 7, 8};
        Assert.assertEquals(expected, actual);
    }
}
