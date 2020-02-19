/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import utils.HashFunction;

/**
 *
 * @author k
 */
public class MyHashSetTest {

    MyHashSet set;

    public MyHashSetTest() {
    }

    @Before
    public void setUp() {
        set = new MyHashSet(new HashFunction());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void TestOnSmallSet() {
        set.add("Malmi");
        set.add("Suomenoja");
        set.add("Oittaa");
        assertTrue(set.contains("Suomenoja"));
        set.remove("Suomenoja");
        assertFalse(set.contains("Suomenoja"));
    }

    @Test
    public void testOnLargeSet() {
        for (int i = 0; i < 100000; i++) {
            set.add("entry" + i);
        }

        assertTrue(set.contains("entry3826"));
        assertTrue(set.contains("entry98234"));
    }

    @Test
    public void insertSameValues() {
        set.add("Pasila");
        set.add("Pasila");
        set.add("Pasila");
        assertTrue(set.contains("Pasila"));
        set.remove("Pasila");
        assertFalse(set.contains("Pasila"));
    }

    @Test
    public void testHashClash() {
        HashFunction function = Mockito.mock(HashFunction.class);
        Mockito.when(function.polynomialHash("Pasila", 10000)).thenReturn(20);
        Mockito.when(function.polynomialHash("Mellunmäki", 10000)).thenReturn(20);
        Mockito.when(function.polynomialHash("Ylistaro", 10000)).thenReturn(20);
        MyHashSet mySet = new MyHashSet(function);
        mySet.add("Pasila");
        mySet.add("Mellunmäki");
        mySet.add("Ylistaro");
        assertTrue(mySet.contains("Pasila"));
        assertTrue(mySet.contains("Mellunmäki"));
        assertTrue(mySet.contains("Ylistaro"));
        mySet.remove("Mellunmäki");
        assertFalse(mySet.contains("Mellunmäki"));

    }
}
