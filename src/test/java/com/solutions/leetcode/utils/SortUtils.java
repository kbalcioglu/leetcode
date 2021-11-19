package com.solutions.leetcode.utils;


public class SortUtils {
    /*
        STABLE      -> Relative ordering of duplicate items will be preserved
        UNSTABLE    -> Relative ordering of duplicate items will not be preserved
        PERFORMANCE -> WORSE TO BETTER => O(n^2) - O(n log n) - O(n) - O(log n) - O(1)
     */

    /**
     * Sort Ascending InPlace Algorithm - Quadratic O(n^2) STABLE
     */
    public static void bubbleSortAsc(int[] array) {
        if (array.length == 1)
            return;
        int unsortedPartitionIndex = array.length - 1;
        while (unsortedPartitionIndex > 0) {
            for (int i = 1; i <= unsortedPartitionIndex; i++) {
                if (array[i - 1] > array[i]) { // if >= then UNSTABLE
                    swap(array, i, i - 1);
                }
            }
            unsortedPartitionIndex--;
        }
    }

    /**
     * Sort Descending InPlace Algorithm - Quadratic O(n^2) STABLE
     */
    public static void bubbleSortDesc(int[] array) {
        if (array.length == 1)
            return;
        int unsortedPartitionIndex = array.length - 1;
        while (unsortedPartitionIndex > 0) {
            for (int i = 1; i <= unsortedPartitionIndex; i++) {
                if (array[i - 1] < array[i]) { // if <= then UNSTABLE
                    swap(array, i, i - 1);
                }
            }
            unsortedPartitionIndex--;
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        if (index1 == index2)
            return;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    /**
     * Sort Ascending InPlace Algorithm - Quadratic O(n^2) UNSTABLE
     */
    public static void selectionSortAsc(int[] array) {
        if (array.length == 1)
            return;
        int unsortedPartitionIndex = array.length - 1;
        int largestIndex = 0;
        while (unsortedPartitionIndex > 0) {
            for (int i = 1; i <= unsortedPartitionIndex; i++) {
                if (array[i] > array[largestIndex]) {
                    largestIndex = i;
                }
            }
            swap(array, unsortedPartitionIndex, largestIndex);
            largestIndex = 0;
            unsortedPartitionIndex--;
        }
    }

    /**
     * Sort Descending InPlace Algorithm - Quadratic O(n^2) UNSTABLE
     */
    public static void selectionSortDesc(int[] array) {
        if (array.length == 1)
            return;
        int unsortedPartitionIndex = array.length - 1;
        int smallestIndex = 0;
        while (unsortedPartitionIndex > 0) {
            for (int i = 1; i <= unsortedPartitionIndex; i++) {
                if (array[smallestIndex] > array[i]) {
                    smallestIndex = i;
                }
            }
            swap(array, unsortedPartitionIndex, smallestIndex);
            smallestIndex = 0;
            unsortedPartitionIndex--;
        }
    }

    /**
     * Sort Ascending InPlace Algorithm - Quadratic O(n^2) STABLE
     */
    public static void insertionSortAsc(int[] array) {
        if (array.length == 1)
            return;
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            int i = firstUnsortedIndex;
            while (i > 0 && array[i - 1] > newElement) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = newElement;
        }
    }

    /**
     * Sort Descending InPlace Algorithm - Quadratic O(n^2) STABLE
     */
    public static void insertionSortDesc(int[] array) {
        //20, 35, -15, 7, 55, 1, -22
        if (array.length == 1)
            return;
        for (int i = array.length - 2; i >= 0; i--) {
            int newElement = array[i]; // 1
            int j = i;
            while (j < array.length - 1 && array[j + 1] > newElement) {
                array[j] = array[j + 1];
                j++;
            }
            array[j] = newElement;
        }
    }

    /**
     * Sort Ascending InPlace Algorithm - Worst case Quadratic O(n^2) but usually better UNSTABLE
     * Can be performed over bubble sort and insertion sort if gap = 1 then normal bubble or insertion sort
     * less swap so better performance - do preliminary sort before actual sort
     */
    public static void shellSortAsc(int[] array) {
        if (array.length == 1)
            return;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }

    /**
     * Sort Descending InPlace Algorithm - Worst case Quadratic O(n^2) but usually better UNSTABLE
     * Can be performed over bubble sort and insertion sort if gap = 1 then normal bubble or insertion sort
     * less swap so better performance - do preliminary sort before actual sort
     */
    public static void shellSortDesc(int[] array) {
        if (array.length == 1)
            return;

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = array.length - 2; i >= 0; i--) {
                int newElement = array[i]; // 1
                int j = i;
                while (j < array.length - gap && array[j + gap] > newElement) {
                    array[j] = array[j + gap];
                    j += gap;
                }
                array[j] = newElement;
            }
        }
    }

    /**
     * Sort Ascending, NOT InPlace, O(n log n), STABLE
     */
    public static void mergeSortAsc(int[] array) {
        if (array.length == 1)
            return;
        divideAndSort(array, 0, array.length, true);

    }

    /**
     * Sort Descending, NOT InPlace, O(n log n), STABLE
     */
    public static void mergeSortDesc(int[] array) {
        if (array.length == 1)
            return;
        divideAndSort(array, 0, array.length, false);

    }

    private static void divideAndSort(int[] array, int start, int end, boolean ascending) {
        if (end - start < 2)
            return;
        int mid = (start + end) / 2;
        divideAndSort(array, start, mid, ascending);
        divideAndSort(array, mid, end, ascending);
        merge(array, start, mid, end, ascending);
    }

    private static void merge(int[] array, int start, int mid, int end, boolean ascending) {
        if ((ascending && array[mid - 1] <= array[mid]) || (!ascending && array[mid - 1] >= array[mid])) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;
        int[] tempArray = new int[end - start];

        while (i < mid && j < end) {
            if (ascending)
                tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++]; // STABLE <=
            else
                tempArray[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++]; // STABLE <=
        }
        // No need to left over for right because they are in right positions.
        // left overs in left array
        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(tempArray, 0, array, start, tempIndex);
    }

    /**
     * Sort Ascending, InPlace, O(n log n), UNSTABLE
     * in worst case -> O(n^2)
     * in most cases better than mergeSort
     */
    public static void quickSortAsc(int[] array) {
        quickSort(array, 0, array.length, true);
    }

    /**
     * Sort Descending, InPlace, O(n log n), UNSTABLE
     * in worst case -> O(n^2)
     * in most cases better than mergeSort
     */
    public static void quickSortDesc(int[] array) {
        quickSort(array, 0, array.length, false);
    }

    private static void quickSort(int[] array, int start, int end, boolean ascending) {
        if (end - start < 2)
            return;
        int pivotIndex = partition(array, start, end, ascending);
        quickSort(array, start, pivotIndex, ascending);
        quickSort(array, pivotIndex + 1, end, ascending);
    }

    private static int partition(int[] array, int start, int end, boolean ascending) {
        int pivot = array[start];
        int i = start;
        int j = end;

        while (i < j) {
            // empty loop, first increment then assign ==> j = 4 ==> array[--j] -> array[3] && j == 3 ||  array[j--] -> array[4] && j == 3
            if (ascending)
                while (i < j && array[--j] >= pivot) ;
            else
                while (i < j && array[--j] <= pivot) ;

            if (i < j) {
                array[i] = array[j];
            }
            if (ascending)
                while (i < j && array[++i] <= pivot) ;
            else
                while (i < j && array[++i] >= pivot) ;
            if (i < j) {
                array[j] = array[i];
            }
        }
        array[j] = pivot;
        return j;
    }

}
