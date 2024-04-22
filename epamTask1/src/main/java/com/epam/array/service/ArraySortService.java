package com.epam.array.service;

import com.epam.array.entity.CustomArray;
import com.epam.array.exception.ArrayException;

public interface ArraySortService {
    void sortSelection(CustomArray array) throws ArrayException;
    void sortInsertion(CustomArray array) throws ArrayException;

}
