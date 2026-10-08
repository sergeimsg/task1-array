package com.task.entity;

import com.task.exception.ArrayUserException;

import java.util.Arrays;

/**
 * Entity class that wraps a primitive int array.
 * The internal array is defensively copied on construction and access.
 */
public class IntegerArray extends AbstractArray {

    protected int[] data;

    public IntegerArray(int[] value) throws ArrayUserException {
        if (value == null) {
            throw new ArrayUserException("Array value cannot be null");
        } else if (value.length == 0) {
            data = value;
        } else {
            this.data = Arrays.copyOf(value, value.length);
        }
    }

    @Override
    public int[] getData() {
        return Arrays.copyOf(data, data.length);
    }


    @Override
    public int getLength() {

        return data.length;
    }

    public int getElementAt(int index) throws ArrayUserException {
        if (index < 0 || index >= data.length) {
            throw new ArrayUserException("Index out of bounds: " + index);
        }
        return data[index];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntegerArray other = (IntegerArray) obj;
        if (data.length != other.data.length) {
            return false;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != other.data[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int value : data) {
            result = 31 * result + value;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntegerArray{data=[");
        for (int i = 0; i < data.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(data[i]);
        }
        sb.append("]}");
        return sb.toString();
    }
}
