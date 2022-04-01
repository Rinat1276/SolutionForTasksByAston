package com.astondevs;

import java.util.Comparator;

/**
 * Class for check methods {@link com.astondevs.CustomArrayImpl}
 *
 * @author Rinat Davlitshin
 */
public class App 
{
    public static void main( String[] args ) {
        CustomArray<Integer> array = new CustomArrayImpl<>();
        System.out.println("array: " + array);
        System.out.println("isEmpty: " + array.isEmpty());
        System.out.println("size: " + array.size());
        for (int i = 0; i < 25; i++) {
            array.create((int)(Math.random() * 100));
        }
        System.out.println("array: " + array);
        System.out.println("isEmpty: " + array.isEmpty());
        System.out.println("size: " + array.size());
        array.upgrade(5, 100);
        array.delete(20);
        System.out.println("array: " + array);
        System.out.println("size: " + array.size());

        Comparator<Integer> cmp = (Integer lhs, Integer rhs) -> {
            if (lhs.equals(rhs))
                return 0;
            if (lhs < rhs)
                return 1;
            else
                return -1;
        };
        array.sort(cmp);

        System.out.println("after sort: " + array);
    }
}
