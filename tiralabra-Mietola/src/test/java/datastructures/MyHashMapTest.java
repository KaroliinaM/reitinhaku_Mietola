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
import org.mockito.Mockito;
import data.Stop;
import utils.HashFunction;

/**
 * My implementation of HashMap structure. returns the value thet is set to the
 * key, or null if there's no value
 *
 * @author k
 */
public class MyHashMapTest {

    MyHashMap hashMap;

    public MyHashMapTest() {
        hashMap = new MyHashMap(new HashFunction());
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBasicInsert() {
        Stop stop = new Stop();
        stop.setGtfsId("ekapysäkki");
        hashMap.put("eka", stop);
        stop = new Stop();
        stop.setGtfsId("tokapysäkki");
        hashMap.put("toka", stop);
        stop = new Stop();
        stop.setGtfsId("kolmaspysäkki");
        hashMap.put("kolmas", stop);
        stop = new Stop();
        stop.setGtfsId("neljäspysäkki");
        hashMap.put("neljäs", stop);
        Stop fromMap = hashMap.get("kolmas");
        assertEquals(fromMap.getGtfsId(), "kolmaspysäkki");
        fromMap = hashMap.get("eka");
        assertEquals(fromMap.getGtfsId(), "ekapysäkki");
    }

    @Test
    public void testMassiveInsert() {
        Stop stop;
        for (int i = 0; i < 100000; i++) {
            stop = new Stop();
            stop.setGtfsId("pysäkki" + i);
            hashMap.put("entry" + i, stop);
        }
        Stop fromMap = hashMap.get("entry52");
        assertEquals(fromMap.getGtfsId(), "pysäkki52");
        fromMap = hashMap.get("entry24787");
        assertEquals(fromMap.getGtfsId(), "pysäkki24787");
    }

    @Test
    public void getNonexistent() {
        assertEquals(hashMap.get("30"), null);
    }

    @Test
    public void twoValuesWithSameKey() {
        Stop stop = new Stop();
        stop.setGtfsId("pysäkki");
        hashMap.put("entry", stop);
        stop = new Stop();
        stop.setGtfsId("toinenpysäkki");
        hashMap.put("entry", stop);
        Stop fromMap = hashMap.get("entry");
        assertEquals(fromMap.getGtfsId(), "toinenpysäkki");
    }

    @Test
    public void hashClash() {
        HashFunction f = Mockito.mock(HashFunction.class);
        Mockito.when(f.polynomialHash("entry1", 10000)).thenReturn(20);
        Mockito.when(f.polynomialHash("entry2", 10000)).thenReturn(20);
        Mockito.when(f.polynomialHash("entry3", 10000)).thenReturn(20);
        MyHashMap map = new MyHashMap(f);
        Stop stop;
        for (int i = 1; i <= 3; i++) {
            stop = new Stop();
            stop.setGtfsId("pysäkki" + i);
            map.put("entry" + i, stop);
        }
        Stop fromMap = map.get("entry2");
        assertEquals(fromMap.getGtfsId(), "pysäkki2");
        fromMap = map.get("entry1");
        assertEquals(fromMap.getGtfsId(), "pysäkki1");
        fromMap = map.get("entry3");
        assertEquals(fromMap.getGtfsId(), "pysäkki3");
    }
}
