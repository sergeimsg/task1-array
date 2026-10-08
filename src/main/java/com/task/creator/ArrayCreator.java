package com.task.creator;

import com.task.entity.IntegerArray;
import com.task.exception.ArrayUserException;

import java.util.List;

/**
 * Service interface for creating IntegerArray objects from a file.
 */
public interface ArrayCreator {

    List<IntegerArray> createArraysFromFile(String filePath) throws ArrayUserException;
}
