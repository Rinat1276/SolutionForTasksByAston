package com.astondevs;

import java.util.Comparator;
import java.util.Random;

/**
 * A class that implements quick sort
 *
 * @author Rinat Davlitshin
 */
public class QuickSort {
    public static final Random RANDOM = new Random();

    /**
     * Public method for sorting collections.
     * Recursively checks all elements of the collection and
     * sorts it according to the passed comparator parameter.
     * @param array - array for sort
     * @param cmp - argument comparator for sort
     */
    public void sort(Object[] array, Comparator cmp) {
        quickSort(array, 0, array.length - 1, cmp);
    }

    private void quickSort(Object[] array, int begin, int end, Comparator cmp) {
        if (end > begin) {
            int index = partition(array, begin, end, cmp);
            quickSort(array, begin, index - 1, cmp);
            quickSort(array, index + 1, end, cmp);
        }
    }

    private int partition(Object[] array, int begin, int end, Comparator cmp) {
        int index = begin + RANDOM.nextInt(end - begin + 1);
        Object pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (cmp.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    private void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
