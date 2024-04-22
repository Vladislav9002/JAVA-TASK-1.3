package com.epam.array.repository.spec.impl;

import com.epam.array.entity.CustomArray;
import com.epam.array.repository.spec.Specification;
import com.epam.array.service.ArrayService;
import com.epam.array.service.impl.ArrayServiceImpl;

public class AverageSpecification implements Specification {

    private double average;

    public AverageSpecification(double average){
        this.average = average;
    }
    @Override
    public boolean specify(CustomArray array) {
        ArrayService service = new ArrayServiceImpl();

        double currentAverage = service.findAverage(array);

        return currentAverage < average;

    }
}
