package com.epam.array.comparator;

import com.epam.array.entity.CustomArray;
import com.epam.array.service.ArrayService;
import com.epam.array.service.impl.ArrayServiceImpl;

import java.util.Comparator;

public class ArrayMaxElementComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        ArrayService service = new ArrayServiceImpl();
        return service.findMax(o1) - service.findMax(o2);
    }
}
