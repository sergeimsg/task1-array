package com.task.service;

import com.task.entity.IntegerArray;
import com.task.exception.ArrayUserException;

import java.util.Optional;

/**
 * Service interface for array operations.
 */
public interface ArrayService {

    Optional<Integer> findMin(IntegerArray array) throws ArrayUserException;

    Optional<Integer> findMax(IntegerArray array) throws ArrayUserException;

    Optional<Integer> calculateSum(IntegerArray array) throws ArrayUserException;

    Optional<Double> calculateAverage(IntegerArray array) throws ArrayUserException;

    IntegerArray bubbleSort(IntegerArray array) throws ArrayUserException;

    IntegerArray quickSort(IntegerArray array) throws ArrayUserException;
}
