package com.astondevs;

import java.util.Comparator;

/**
 * Interface for own implementation ArrayList.
 *
 * @author Rinat Davlitshin
 * Type parameters:
 * <T> – the type of elements in this list
 */
public interface CustomArray<T> {

    /**
     * Getting list size.
     *
     * @return list size
     */
    int size();

    /**
     * Checking if a list is empty.
     *
     * @return true if list is empty
     */
    boolean isEmpty();

    /**
     * Add single item.
     *
     * @param item
     * @return true on success
     */
    boolean create(T item);

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    T read(int index);

    /**
     * Set item by index.
     *
     * @param index
     * @param item
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    boolean upgrade(int index, T item);

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws IndexOutOfBoundsException if index is out of bounds
     */
    boolean delete(int index);

    /**
     * Sorts any collection by the given comparator.
     *
     * @param cmp
     */
    void sort(Comparator<T> cmp);

    /**
     * Get content in format '[ element1, element2, ... ,elementN ] or [ ] if empty.
     *
     * @return List of entities in the collection
     */
    String toString();
}
