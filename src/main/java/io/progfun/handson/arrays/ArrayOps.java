package io.progfun.handson.arrays;

public class ArrayOps {
    public int findLargestIndex(long[] array) {
        int largestIndex = 0;
        int arrayLength = array.length;
        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            if (array[currentIndex] > array[largestIndex]) {
                largestIndex = currentIndex;
            }
        }
        return largestIndex;
    }

    public int findSecondLargestIndex(long[] array) {
        int largestIndex = 0;
        int secondLargestIndex = -1;
        int arrayLength = array.length;
        // If there is only 1 element , then there is no second largest element
        if (arrayLength < 2)
            return -1;
        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            // If it is greater than the largest number , the swap happens
            if (array[currentIndex] > array[largestIndex]) {
                secondLargestIndex = largestIndex;
                largestIndex = currentIndex;
            }
            // This is the case where the new number is less than array[largest] number
            // known.
            // If the current element is bigger than already known second largest , we swap.
            // -1 is to handle special cases
            else if (array[currentIndex] != array[largestIndex]) {
                if (secondLargestIndex == -1 || array[currentIndex] > array[secondLargestIndex]) {
                    secondLargestIndex = currentIndex;
                }
            }
        }
        // If there was an array that had only repeating elements then there is no
        // secondLargest Index
        return secondLargestIndex;
    }

    public boolean isSortedArray(long[] array) {
        int arrayLength = array.length;
        for (int currentIndex = 1; currentIndex < arrayLength; currentIndex++) {
            if (array[currentIndex] < array[currentIndex - 1])
                return false;
        }
        return true;
    }

    // two pointer approach
    public long[] reverseArray(long[] arrayToReverse) {
        int arrayLength = arrayToReverse.length;
        if (arrayLength == 1)
            return arrayToReverse;
        int highCurrentIndex = arrayLength - 1;
        long[] reversedArray = new long[arrayLength];
        for (int lowCurrentIndex = 0; lowCurrentIndex < arrayLength; lowCurrentIndex++, highCurrentIndex--) {
            if (lowCurrentIndex <= highCurrentIndex) {
                reversedArray[lowCurrentIndex] = arrayToReverse[highCurrentIndex];
                reversedArray[highCurrentIndex] = arrayToReverse[lowCurrentIndex];
            }
        }
        return reversedArray;
    }

}
