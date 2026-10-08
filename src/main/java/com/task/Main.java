package com.task;


import com.task.creator.ArrayCreator;
import com.task.creator.ArrayCreatorImpl;
import com.task.entity.IntegerArray;
import com.task.exception.ArrayUserException;
import com.task.factory.ArrayFactory;
import com.task.factory.impl.IntegerArrayFactory;
import com.task.parser.ArrayParser;
import com.task.parser.impl.ArrayParserImpl;
import com.task.reader.DataReader;
import com.task.reader.impl.DataReaderImpl;
import com.task.service.ArrayService;
import com.task.service.impl.ArrayServiceImpl;
import com.task.validator.ArrayValidator;
import com.task.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

/**
 * Application entry point demonstrating Factory Method and Builder patterns,
 * file reading, validation, parsing, and array service operations.
 */
public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws ArrayUserException {
        Main main = new Main();
        main.run();
    }

    public void run() throws ArrayUserException {
        DataReader reader = new DataReaderImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new IntegerArrayFactory();
        ArrayCreator creator = new ArrayCreatorImpl(reader, validator, parser, factory);
        ArrayService service = new ArrayServiceImpl();

        String filePath = "src/main/resources/data/array_data.txt";
        logger.info("Reading arrays from: {}", filePath);

        List<IntegerArray> arrays = creator.createArraysFromFile(filePath);

        for (int i = 0; i < arrays.size(); i++) {
            IntegerArray array = arrays.get(i);
            logger.info("Array #{}: {}", i, array);

            if (array.getLength() > 0) {
                Optional<Integer> min = service.findMin(array);
                Optional<Integer> max = service.findMax(array);
                Optional<Integer> sum = service.calculateSum(array);
                Optional<Double> avg = service.calculateAverage(array);

                logger.info("  Min={}, Max={}, Sum={}, Average={}",
                        min.orElse(null), max.orElse(null),
                        sum.orElse(null), avg.orElse(null));

                IntegerArray bubbleSorted = service.bubbleSort(array);
                IntegerArray quickSorted = service.quickSort(array);
                logger.info("  Bubble sorted: {}", bubbleSorted);
                logger.info("  Quick sorted:  {}", quickSorted);
            } else {
                logger.info("  Empty array — no operations to perform");
            }
        }


    }
}
