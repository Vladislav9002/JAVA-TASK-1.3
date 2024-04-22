package com.epam.array.repository.impl;

import com.epam.array.comparator.ArrayIdComparator;
import com.epam.array.comparator.ArrayLengthComparator;
import com.epam.array.comparator.ArrayMaxElementComparator;
import com.epam.array.entity.CustomArray;
import com.epam.array.repository.ArrayRepository;
import com.epam.array.repository.spec.Specification;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class ArrayRepositoryImpl implements ArrayRepository {


    private static final ArrayRepositoryImpl instance = new ArrayRepositoryImpl();

    public static ArrayRepositoryImpl getInstance(){
        return instance;
    }

    private ArrayRepositoryImpl() {
        this.customArrays = new ArrayList<>();
    }

    private List<CustomArray> customArrays;
    public ArrayRepositoryImpl(List<CustomArray> customArrays) {
        this.customArrays = new ArrayList<>();
    }

    public List<CustomArray> getCustomArrays() {
        return customArrays;
    }

    public List<CustomArray> queryStream(Specification specification) {
        List<CustomArray> results =
                customArrays.stream().filter(array -> specification.specify(array)).toList();
        return results;
    }


    public CustomArray get(int index) {
        return customArrays.get(index);
    }

    @Override
    public boolean add(CustomArray array) {
        return customArrays.add(array);
    }

    @Override
    public boolean remove(CustomArray array) {
        return customArrays.remove(array);
    }


    public List<CustomArray> query(Specification specification) {
        List<CustomArray> results = new ArrayList<>();

        for (CustomArray array : customArrays) {
            if (specification.specify(array)) {
                results.add(array);
            }
        }
        return results;
    }


    @Override
    public String toString() {
        return "ArrayRepositoryImpl{" +
                "customArrays=" + customArrays +
                '}';
    }


    public void sortByMaxElement(){
        Comparator comparator = new ArrayMaxElementComparator();
        Collections.sort(customArrays, comparator);
    }
    public void sortByLength(){
        Comparator comparator = new ArrayLengthComparator();
        Collections.sort(customArrays, comparator);
    }

    public void sortById(){
        Comparator comparator = new ArrayIdComparator();
        Collections.sort(customArrays, comparator);
    }

}
