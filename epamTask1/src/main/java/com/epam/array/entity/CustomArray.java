package com.epam.array.entity;


import com.epam.array.observer.ArrayStatisticsObserver;
import com.epam.array.observer.impl.ArrayStatisticsObserverImpl;
import com.epam.array.util.IdGenerator;

import java.util.Arrays;
import java.util.Random;

public class CustomArray {
    private int[] array;
    private int arrayId;
    private ArrayStatisticsObserver observer;


    public CustomArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.arrayId = IdGenerator.generateId();
    }


    @Override
    public String toString() {
        return "CustomArray{" +
                "array=" + Arrays.toString(array) +
                ", arrayId=" + arrayId +
                '}' + "\n";
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getElement(int index) {
        return array[index];
    }

    public int getArrayId() {
        return arrayId;
    }

    public int length() {
        return array.length;
    }


    public void removeObserver() {
        observer = null;
    }

    public void addObserver() {
        observer = new ArrayStatisticsObserverImpl();
    }

    public void setArrayId(int id) {
        if(arrayId > 0) {
            arrayId = id;
        } else {
            this.arrayId = new Random().nextInt();
        }
    }
    private void notifyObserver() {
        if (observer != null) {
            observer.changeArrayElement(this);
        }
    }

    public void setArray(int[] array) {
        if(array != null && array.length > 0) {
            this.array = array;
        } else {
            this.array = new int[]{0};
        }
        notifyObserver();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        if (arrayId != that.arrayId) return false;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + arrayId;
        return result;
    }
}
