/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import data.Connection;


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
    public void testObjectRemove() {
        list.insertObject(new Connection("alku", "loppu", 50, 100, "13"));
        list.insertObject(new Connection("toinenalku", "toinenloppu", 50, 100, "12"));
        list.insertObject(new Connection("kolmasalku", "kolmasloppu", 50, 100, "12"));
        list.removeObject(1);
        list.removeObject(0);
        assertEquals(list.returnObjLength(), 1);
        Connection connection = (Connection) list.getObject(0);
        assertEquals(connection.getDepartureStop(), "kolmasalku");
    }

    @Test
    public void testStringRemove() {
        list.insertString("Pasila");
        list.insertString("Myllypuro");
        list.insertString("Kumpula");
        list.removeString(0);
        list.removeString(0);
        assertEquals(list.returnStringLength(), 1);
        assertEquals(list.getString(0), "Kumpula");
    }

    @Test
    public void testReverse() {
        String[] stops = {"Pasila", "Pitäjänmäki", "Etelä-Haaga", "Suutarila", "Töyrynummi",
            "Tuomarila", "Nuuksio", "Lauttasaari", "Ruoholahti", "Kallio", "Merihaka"};
        for (int i = 0; i < 10; i++) {
            list.insertObject(new Connection(stops[i], stops[i + 1], 50, 100, "0"));
        }
        list.reverseObject();
        for (int i = 0; i < 10; i++) {
            Connection c = (Connection) list.getObject(i);
            assertEquals(c.getDepartureStop(), stops[stops.length - 2 - i]);
        }
        list.removeObject(0);
        list.reverseObject();
        for (int i = 0; i < 9; i++) {
            Connection c = (Connection) list.getObject(i);
            assertEquals(c.getDepartureStop(), stops[i]);
        }

    }

}
