package com.epam.array.repository;

import com.epam.array.entity.CustomArray;
import com.epam.array.repository.spec.Specification;

import java.util.List;

public interface ArrayRepository {
    boolean add(CustomArray array);
    boolean remove(CustomArray array);

   List<CustomArray> queryStream(Specification specification);

   CustomArray get(int index);


}
