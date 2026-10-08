package com.task.creator.impl;

import com.task.creator.ArrayCreator;
import com.task.entity.IntegerArray;
import com.task.exception.ArrayUserException;
import com.task.factory.ArrayFactory;
import com.task.parser.ArrayParser;
import com.task.reader.DataReader;
import com.task.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Coordinates reading, validation, parsing, and creation of IntegerArray objects.
 */
public class ArrayCreatorImpl implements ArrayCreator {

    private static final Logger logger = LogManager.getLogger();

    private final DataReader reader;
    private final ArrayValidator validator;
    private final ArrayParser parser;
    private final ArrayFactory factory;

    public ArrayCreatorImpl(DataReader reader, ArrayValidator validator,
                            ArrayParser parser, ArrayFactory factory) {
        this.reader = reader;
        this.validator = validator;
        this.parser = parser;
        this.factory = factory;
    }

    @Override
    public List<IntegerArray> createArraysFromFile(String filePath) throws ArrayUserException {
        List<String> lines = reader.readLines(filePath);
        List<IntegerArray> result = new ArrayList<>();
        for (String line : lines) {
            if (validator.isLineValid(line)) {
                int[] data = parser.parse(line);
                IntegerArray array = factory.createArray(data);
                result.add(array);
                logger.info("Created array from valid line: '{}'", line);
            } else {
                logger.warn("Skipped invalid line: '{}'", line);
            }
        }
        logger.info("Total arrays created: {}", result.size());
        return result;
    }
}
