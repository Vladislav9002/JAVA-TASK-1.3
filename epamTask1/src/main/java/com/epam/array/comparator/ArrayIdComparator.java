package com.epam.array.comparator;

import com.epam.array.entity.CustomArray;

import java.util.Comparator;

public class ArrayIdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        return o1.getArrayId() - o2.getArrayId();
    }
}
