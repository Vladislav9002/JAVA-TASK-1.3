package com.epam.array.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class ArrayWarehouse {

    private static final ArrayWarehouse instance = new ArrayWarehouse();

    private Map<Integer, ArrayStatistics> map = new HashMap<>();

    private ArrayWarehouse() {
    }

    public static ArrayWarehouse getInstance(){
        return instance;
    }

    public ArrayStatistics put(Integer key, ArrayStatistics value){
        return map.put(key, value);
    }

    public ArrayStatistics remove(Integer key){
        return map.remove(key);
    }

}
