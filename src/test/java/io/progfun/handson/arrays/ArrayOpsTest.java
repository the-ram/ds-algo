package io.progfun.handson.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayOpsTest {
    private ArrayOps largestOps;

    @BeforeEach
    void initialize() {
        largestOps = new ArrayOps();
    }

    @DisplayName("Test largestOps.findLargestIndex")
    @Test
    void testLargestInOnePass() {
        long[] arrayToTest = new long[] { 5l, 22l, 11l, 99l, 66l, 66l };
        int actualIndex = largestOps.findLargestIndex(arrayToTest);
        assertEquals(3, actualIndex);
    }

    @DisplayName("Test largestOps.findSecondLargest")
    @Test
    void testSecondLargestInOnePass() {
        long[] arrayToTest = new long[] { 5l, 22l, 11l, 99l, 66l, 99l };
        int actualIndex = largestOps.findSecondLargestIndex(arrayToTest);
        assertEquals(4, actualIndex);
    }

    @DisplayName("Test largestOps.testSecondLargestInUnaryArray")
    @Test
    void testSecondLargestInUnaryArray() {
        long[] arrayToTest = new long[] { 5l };
        int actualIndex = largestOps.findSecondLargestIndex(arrayToTest);
        assertEquals(-1, actualIndex);
    }

    @DisplayName("Test largestOps.findLargestIndex")
    @Test
    void testLargestInAdditionalCase() {
        long[] arrayToTest = new long[] { 12l, 12l, 12l, 7l };
        int actualIndex = largestOps.findSecondLargestIndex(arrayToTest);
        assertEquals(3, actualIndex);
    }

    @DisplayName("Test largestOps.testSecondLargestInRepeatingArray")
    @Test
    void testSecondLargestInRepeatingArray() {
        long[] arrayToTest = new long[] { 5l, 5l, 5l, 5l };
        int actualIndex = largestOps.findSecondLargestIndex(arrayToTest);
        assertEquals(-1, actualIndex);
    }

    @DisplayName("Test largestOps.checkIfArrayIsSorted")
    @Test
    void checkIfArrayIsSorted() {
        long[] arrayToTest = new long[] { 5l, 5l, 5l, 5l };
        assertTrue(largestOps.isSortedArray(arrayToTest));

        long[] arrayToTest2 = new long[] { 5l };
        assertTrue(largestOps.isSortedArray(arrayToTest2));

        long[] arrayToTest3 = new long[] { 5l, 15l, 15l, 25l };
        assertTrue(largestOps.isSortedArray(arrayToTest3));

        long[] arrayToTest4 = new long[] { 5l, 15l, 15l, 5l };
        assertFalse(largestOps.isSortedArray(arrayToTest4));

    }

    @DisplayName("Test largestOps.reverseArray")
    @Test
    void checkForReversedArray() {
        long[] arrayToReverse = new long[] { 1, 2, 3, 4 };
        long[] expectedReversedArray = new long[] { 4, 3, 2, 1 };
        long[] actualReversedArray = largestOps.reverseArray(arrayToReverse);
        assertArrayEquals(expectedReversedArray, actualReversedArray);

        //odd number case
        long[] arrayToReverse2 = new long[] { 1, 2, 3, 4 ,5 };
        long[] expectedReversedArray2 = new long[] { 5 , 4, 3, 2, 1 };
        long[] actualReversedArray2 = largestOps.reverseArray(arrayToReverse2);
        assertArrayEquals(expectedReversedArray2, actualReversedArray2);
    }

}