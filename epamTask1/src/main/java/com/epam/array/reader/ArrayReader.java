package com.epam.array.reader;

import com.epam.array.exception.ArrayException;

import java.util.List;

public interface ArrayReader {

    List<int[]> readArray(String filename) throws ArrayException;


}
