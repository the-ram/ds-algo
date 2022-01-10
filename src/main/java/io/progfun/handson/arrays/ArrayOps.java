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

    // two pointer approach. One iteration can be reduced if an in-place replace is
    // used as well
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

    // Given an array move non duplicates upfront in place and then return size .
    // Note input is sorted already
    public int removeDuplicatesInPlace(long[] duplicatesToReplace) {
        int arrayLength = duplicatesToReplace.length;
        int resIndex = 1;

        for (int currentIndex = 1; currentIndex < arrayLength; currentIndex++) {
            if (duplicatesToReplace[currentIndex] != duplicatesToReplace[resIndex - 1]) {
                duplicatesToReplace[resIndex] = duplicatesToReplace[currentIndex];
                resIndex++;
            }
        }
        return resIndex;
    }

    public long[] moveZerosToEnd(long[] arrayWithZeros) {
        int arrayLength = arrayWithZeros.length;
        int countOfNonZeros = 0;
        for (int currentIndex = 0; currentIndex < arrayLength; currentIndex++) {
            if (arrayWithZeros[currentIndex] != 0) {
                long temp = arrayWithZeros[currentIndex];
                long swapIndex = arrayWithZeros[countOfNonZeros];
                arrayWithZeros[countOfNonZeros] = temp;
                arrayWithZeros[currentIndex] = swapIndex;
                countOfNonZeros++;
            }
        }
        return arrayWithZeros;
    }

    public long[] leftRotate(long[] arrayToRotate) {
        int arrayLength = arrayToRotate.length;
        long head = arrayToRotate[0];
        for (int currentIndex = 1; currentIndex < arrayLength; currentIndex++) {
            arrayToRotate[currentIndex - 1] = arrayToRotate[currentIndex];
            if (currentIndex == arrayLength - 1) {
                // last element
                arrayToRotate[currentIndex] = head;
            }
        }
        return arrayToRotate;
    }

    public long[] leftRotateByN(long[] arrayToRotate, int placesToRotate) {
        int arrayLength = arrayToRotate.length;
        long[] placesToMoveArray = new long[placesToRotate];
        for (int currentIndex = 0; currentIndex < placesToRotate; currentIndex++) {
            placesToMoveArray[currentIndex] = arrayToRotate[currentIndex];
        }

        for (int currentIndex = placesToRotate; currentIndex < arrayLength; currentIndex++) {
            arrayToRotate[currentIndex-placesToRotate] = arrayToRotate[currentIndex];
        }

        for (int currentIndex = 0; currentIndex < placesToRotate; currentIndex++) {
            arrayToRotate[arrayLength-placesToRotate+currentIndex] = placesToMoveArray[currentIndex];
        }
        return arrayToRotate;
    }

}
