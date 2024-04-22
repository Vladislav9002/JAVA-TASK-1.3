package com.epam;

import com.epam.array.comparator.ArrayIdComparator;
import com.epam.array.comparator.ArrayLengthComparator;
import com.epam.array.comparator.ArrayMaxElementComparator;
import com.epam.array.entity.ArrayStatistics;
import com.epam.array.entity.ArrayWarehouse;
import com.epam.array.exception.ArrayException;
import com.epam.array.observer.ArrayStatisticsObserver;
import com.epam.array.observer.impl.ArrayStatisticsObserverImpl;
import com.epam.array.reader.ArrayReader;
import com.epam.array.reader.impl.ArrayReaderImpl;
import com.epam.array.repository.ArrayRepository;
import com.epam.array.repository.impl.ArrayRepositoryImpl;
import com.epam.array.repository.spec.impl.AverageSpecification;
import com.epam.array.repository.spec.impl.IdSpecification;
import com.epam.array.service.ArrayService;
import com.epam.array.service.ArraySortService;
import com.epam.array.service.impl.ArrayServiceImpl;
import com.epam.array.service.impl.ArraySortServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.array.entity.CustomArray;
import com.epam.array.repository.spec.impl.AverageSpecification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static Logger logger = LogManager.getLogger();

    static ArrayService arrayService = new ArrayServiceImpl();
    static ArraySortService sortService = new ArraySortServiceImpl();
    static final CustomArray basicArray1 = new CustomArray(new int[]{5, -2, 1, 16, 10, 3});
    static final CustomArray basicArray2 = new CustomArray(new int[]{5, -2, 4, 16, 6, 3});
    static final CustomArray basicArray3 = new CustomArray(new int[]{1, 2, 5, 7, 66, 10});
    static final CustomArray zeroArray = new CustomArray(new int[]{});


    public static void main(String[] args) throws ArrayException {


        ArrayService service = new ArrayServiceImpl();
        ArrayReader arrayReader = new ArrayReaderImpl();

        List<int[]> arraysFromFile = arrayReader.readArray("data\\arrays.txt");
        ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
        repository.add(basicArray1);

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

        for (int[] i : arraysFromFile) {
            CustomArray tempCustomArray = new CustomArray(i);
            repository.add(tempCustomArray);
        }


        System.out.println(repository.toString());

        AverageSpecification averageSpecification = new AverageSpecification(21);


        System.out.println(repository.get(2));
        System.out.println(averageSpecification.specify(repository.get(2)));
        logger.info(repository.toString());

        ArrayLengthComparator lengthComparator = new ArrayLengthComparator();
        Collections.sort(repository.getCustomArrays(), lengthComparator);
        System.out.println(repository.toString());

        ArrayIdComparator idComparator = new ArrayIdComparator();
        Collections.sort(repository.getCustomArrays(), idComparator);
        System.out.println(repository.toString());

        ArrayMaxElementComparator maxElementComparator = new ArrayMaxElementComparator();
        Collections.sort(repository.getCustomArrays(), maxElementComparator);
        System.out.println(repository.toString());


        ArrayStatisticsObserverImpl observer = new ArrayStatisticsObserverImpl();
        service.replaceElement(basicArray1, 666, 2);

        observer.changeArrayElement(basicArray1);

        System.out.println(repository.toString());


    }
}