package com.epam.array.repository.spec.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.repository.spec.SpecificationPredicate;
import com.epam.array.service.ArrayService;
import com.epam.array.service.impl.ArrayServiceImpl;

public class MaxSpecificationPredicate implements SpecificationPredicate {
    private int minRangeMax;
    private int maxRangeMax;

    public MaxSpecificationPredicate(int minRangeMax, int maxRangeMax) {
        this.minRangeMax = minRangeMax;
        this.maxRangeMax = maxRangeMax;
    }

    @Override
    public boolean test(CustomArray array) {
        ArrayService service = new ArrayServiceImpl();
        int currentMax = service.findMax(array);

        return (maxRangeMax >= currentMax && minRangeMax <= currentMax);
    }
}
