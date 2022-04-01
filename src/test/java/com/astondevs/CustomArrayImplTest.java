package com.astondevs;

import org.junit.Assert;
import org.junit.Test;

public class CustomArrayImplTest {
    private CustomArray<Integer> array = new CustomArrayImpl<>();

    @Test
    public void size() {
        Assert.assertEquals(0, array.size());
        for (int i = 1; i < 5; ++i) {
            array.create(i);
            Assert.assertEquals(i, array.size());
        }
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(0, array.size());
    }

    @Test
    public void create() {
        Assert.assertTrue(array.create(2));
        Assert.assertTrue(array.create(-20));
        Assert.assertTrue(array.create(0));
        System.out.println("create >> " + array);
    }

    @Test
    public void read() {
        for (int i = 1; i <= 5; i++)
            array.create(i);

        int expected = array.read(2);
        Assert.assertEquals(java.util.Optional.of(expected), java.util.Optional.ofNullable(array.read(2)));
        expected = array.read(4);
        Assert.assertNotEquals(java.util.Optional.of(expected), java.util.Optional.ofNullable(array.read(1)));
    }

    @Test
    public void upgrade() {
        for (int i = 0; i < 10; i++)
            array.create((int) (Math.random() * 10));

        System.out.println("upgrade >> " + array);
        Assert.assertTrue(array.upgrade(3, 100));
        Assert.assertTrue(array.upgrade(6, 200));
        System.out.println("upgrade >> " + array);
    }

    @Test
    public void delete() {
        for (int i = 0; i < 5; i++)
            array.create(i);

        System.out.println("delete >> " + array);
        Assert.assertTrue(array.delete(2));
        System.out.println("delete >> " + array);
    }
}