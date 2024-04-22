package com.epam.array.comparator;

import com.epam.array.entity.CustomArray;

import java.util.Comparator;

public class ArrayLengthComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.length() - o2.length();
    }
}
