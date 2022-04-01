package com.astondevs;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class for implementation interface {@link com.astondevs.CustomArray}.
 *
 * @author Rinat Davlitshin
 * Type parameters:
 * <T> – the type of elements in this list
 */
public class CustomArrayImpl<T> implements CustomArray<T> {

    /**
     * The array buffer into which the elements of the CustomArray are stored.
     */
    private T[] arrayOfElements;

    /**
     * Variable for array size.
     */
    private int size;

    /**
     * Default initialized construct.
     */
    public CustomArrayImpl() {
        this.arrayOfElements = (T[]) new Object[]{};
    }

    /**
     * Construct with custom capacity initialization.
     * @param capacity
     */
    public CustomArrayImpl(int capacity) {
        if (capacity < 0)
            throw new RuntimeException("You entered illegal argument: " + capacity);
        this.arrayOfElements = (T[]) new Object[capacity];
    }

    /**
     * Returns the number of elements in this list.
     * @return number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds the element received as a parameter to the end of the list.
     * @param item - element to be add to this list
     * @return true
     */
    @Override
    public boolean create(T item) {
        int capacity = arrayOfElements.length;
        if (capacity - (size + 1) < 0)
            capacity = size + 1;
        arrayOfElements = Arrays.copyOf(arrayOfElements, capacity);
        arrayOfElements[size++] = item;
        return true;
    }

    /**
     * For read the element at the specified position.
     * @param index - index of the element
     * @return element at the specified position
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T read(int index) {
        checkIndex(index);
        return arrayOfElements[index];
    }

    /**
     * Updates an element in the collection at the index given as an argument.
     * @param index -  index of the element to upgrade
     * @param item - the element that will replace the previous one
     * @return true
     * @throws IndexOutOfBoundsException
     */
    @Override
    public boolean upgrade(int index, T item) {
        checkIndex(index);
        arrayOfElements[index] = item;
        return true;
    }

    /**
     * Removes the element at the specified position by index.
     * @param index - index of the element to delete
     * @return true
     * @throws IndexOutOfBoundsException
     */
    @Override
    public boolean delete(int index) {
        checkIndex(index);
        int capacity = size - index - 1;
        if (capacity > 0)
            System.arraycopy(arrayOfElements, index + 1, arrayOfElements, index, capacity);
        arrayOfElements[--size] = null;
        trim();
        return true;
    }

    /**
     * To sort a collection by a given comparator.
     * @param cmp - comparator
     */
    @Override
    public void sort(Comparator<T> cmp) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arrayOfElements, cmp);
    }

    /**
     * To display the collection.
     * Uses StringBuilder to include the elements of a collection
     * in a string and display it in human-readable form.
     * @return string with elements collection
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[ ");
        for (int i = 0; i < size; ++i) {
            stringBuilder.append(arrayOfElements[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Wrong index: " + index);
    }

    private void trim() {
        T[] emptyArrays = (T[]) new Object[]{};
        if (size == arrayOfElements.length)
            return;
        if (size < arrayOfElements.length)
            arrayOfElements = (size == 0) ? emptyArrays : Arrays.copyOf(arrayOfElements, size);
    }
}
