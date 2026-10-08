package com.task.creator;

import com.task.creator.impl.ArrayCreatorImpl;
import com.task.entity.IntegerArray;
import com.task.exception.ArrayUserException;
import com.task.factory.ArrayFactory;
import com.task.factory.impl.IntegerArrayFactory;
import com.task.parser.ArrayParser;
import com.task.parser.impl.ArrayParserImpl;
import com.task.reader.DataReader;
import com.task.reader.impl.DataReaderImpl;
import com.task.validator.ArrayValidator;
import com.task.validator.impl.ArrayValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCreatorImplTest {

    private ArrayCreatorImpl creator;

    @BeforeEach
    void setUp() {
        DataReader reader = new DataReaderImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new IntegerArrayFactory();
        creator = new ArrayCreatorImpl(reader, validator, parser, factory);
    }

    @Test
    void createArraysFromFileReturnsValidArrays() throws ArrayUserException {
        String path = "src/test/resources/data/test_data.txt";
        List<IntegerArray> arrays = creator.createArraysFromFile(path);
        assertNotNull(arrays);
        assertTrue(arrays.size() > 0);
    }

    @Test
    void createArraysFromNonExistentFileThrowsException() {
        assertThrows(ArrayUserException.class,
                () -> creator.createArraysFromFile("nonexistent_file.txt"));
    }

    @Test
    void createdArraysHaveCorrectContent() throws ArrayUserException {
        String path = "src/test/resources/data/test_data.txt";
        List<IntegerArray> arrays = creator.createArraysFromFile(path);
        // First valid line "1; 2; 3" should produce [1, 2, 3]
        IntegerArray firstArray = arrays.get(0);
        assertArrayEquals(new int[]{1, 2, 3}, firstArray.getData());
    }
}
