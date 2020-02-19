/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import data.Connection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k
 */
public class MyArrayListTest {

    MyArrayList list;

    public MyArrayListTest() {
    }

    @Before
    public void setUp() {
        list = new MyArrayList();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInt() {
        list.insertInt(5);
        list.insertInt(4);
        list.insertInt(7);
        list.insertInt(20);
        assertEquals(list.getInt(2), 7);
    }

    @Test
    public void testString() {
        list.insertString("eka");
        list.insertString("toka");
        list.insertString("kolmas");
        list.insertString("neljäs");
        assertEquals(list.getString(2), "kolmas");
    }

    @Test
    public void testObject() {
        list.insertObject(new Connection("alku", "loppu", 50, 100, "13"));
        list.insertObject(new Connection("toinenalku", "toinenloppu", 50, 100, "12"));
        list.insertObject(new Connection("kolmasalku", "kolmasloppu", 50, 100, "12"));
        Connection c = (Connection) list.getObject(1);
        assertEquals("toinenalku", c.getDepartureStop());
    }

    @Test
    public void testIntLimits() {
        for (int i = 10; i < 70; i++) {
            list.insertInt(i);
        }
        assertEquals(list.getInt(55), 65);
    }

    @Test
    public void testStringLimits() {
        for (int i = 10; i < 70; i++) {
            list.insertString("luku" + i);
        }
        assertEquals(list.getString(55), "luku65");
    }
    
    @Test
    public void testRemove() {
        list.insertObject(new Connection("alku", "loppu", 50, 100, "13"));
        list.insertObject(new Connection("toinenalku", "toinenloppu", 50, 100, "12"));
        list.insertObject(new Connection("kolmasalku", "kolmasloppu", 50, 100, "12"));
        list.insertObject(new Connection("alku", "loppu", 50, 100, "13"));
        list.insertObject(new Connection("toinenalku", "toinenloppu", 50, 100, "12"));
        list.insertObject(new Connection("kolmasalku", "kolmasloppu", 50, 100, "12"));
        list.removeObject(1);
    }
}
