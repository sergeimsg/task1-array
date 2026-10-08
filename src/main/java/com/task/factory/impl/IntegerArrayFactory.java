package com.task.factory.impl;

import com.task.entity.IntegerArray;
import com.task.exception.ArrayUserException;
import com.task.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Concrete factory that creates IntegerArray instances.
 */
public class IntegerArrayFactory implements ArrayFactory {

    private static final Logger logger = LogManager.getLogger(IntegerArrayFactory.class);

    @Override
    public IntegerArray createArray(int[] data) throws ArrayUserException {
        if (data == null) {
            throw new ArrayUserException("Cannot create array from null data");
        }
        IntegerArray array = new IntegerArray(data);
        logger.debug("Created IntegerArray with length {}", array.getLength());
        return array;
    }
}
