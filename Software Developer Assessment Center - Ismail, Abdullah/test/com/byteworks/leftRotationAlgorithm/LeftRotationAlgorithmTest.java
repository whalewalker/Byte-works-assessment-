package com.byteworks.leftRotationAlgorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.byteworks.leftRotationAlgorithm.LeftRotationAlgorithm.rotLeft;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeftRotationAlgorithmTest {

    @Test
    void testCodeSample() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(3, 4, 5, 1, 2);
        List<Integer> output = rotLeft(arr, 2);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Test case for rotating an array with even number of elements by an even number of rotations")
    void testEvenArrayEvenLeftRotations() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(3, 4, 5, 6, 1, 2);
        List<Integer> output = rotLeft(arr, 2);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Test case for rotating an array with even number of elements by an odd number of rotations")
    void testEvenArrayOddLeftRotations() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expected = Arrays.asList(4, 5, 6, 1, 2, 3);
        List<Integer> output =rotLeft(arr, 3);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Test case for rotating an array with odd number of elements by an even number of rotations")
    void testOddArrayEvenLeftRotations() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(3, 4, 5, 1, 2);
        List<Integer> output = rotLeft(arr, 2);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Test case for rotating an array with odd number of elements by an odd number of rotations")
    void testOddArrayOddLeftRotations() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(4, 5, 1, 2, 3);
        List<Integer> output = rotLeft(arr, 3);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Test case for rotating an array with only one element")
    void testSingleElementArray() {
        List<Integer> arr = Collections.singletonList(1);
        List<Integer> expected = Collections.singletonList(1);
        List<Integer> output = rotLeft(arr, 1);
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Test case for rotating an empty array")
     void testEmptyArray() {
        List<Integer> arr = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        List<Integer> output = rotLeft(arr, 3);
        assertTrue(output.isEmpty());
        assertEquals(expected, output);
    }

    @Test
     void testRotatingZeroTimes() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> output = rotLeft(arr, 0);
        assertEquals(expected, output);
    }
}