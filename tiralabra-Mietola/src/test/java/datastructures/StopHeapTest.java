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
import java.util.Random;
import data.Stop;

/**
 *
 * @author k
 */
public class StopHeapTest {

    StopHeap heap;

    public StopHeapTest() {
    }

    @Before
    public void setUp() {
        heap = new StopHeap();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSmallInput() {
        Stop stop = createStop("eka", 40);
        heap.add(stop);
        stop = createStop("toka", 80);
        heap.add(stop);
        stop = createStop("kolmas", 20);
        heap.add(stop);
        stop = createStop("neljäs", 34);
        heap.add(stop);
        stop = createStop("viides", 62);
        heap.add(stop);
        stop = createStop("kuudes", 15);
        heap.add(stop);
        stop = createStop("seitsemäs", 100);
        heap.add(stop);
        Stop s = heap.poll();
        assertEquals(s.getName(), "kuudes");
        s = heap.poll();
        assertEquals(s.getName(), "kolmas");
        s = heap.poll();
        assertEquals(s.getName(), "neljäs");

    }

    @Test
    public void testLargeInsert() {
        int x = 0;
        Random random = new Random(1337);
        for (int i = 0; i < 70; i++) {
            Stop stop = createStop("", random.nextInt(200));
            heap.add(stop);
        }
        for (int i = 0; i < 60; i++) {
            Stop stop2 = heap.poll();
            assertTrue(stop2.getEstimate() >= x);
            x = stop2.getEstimate();
        }

    }
    @Test
    public void pollEmptyHeap() {
        assertEquals(heap.poll(), null);
    }
    
    @Test
    public void testEmpty() {
        assertTrue(heap.isEmpty());
        heap.add(createStop("", 5));
        heap.add(createStop("", 10));
        assertFalse(heap.isEmpty());
        heap.poll();
        heap.poll();
        assertTrue(heap.isEmpty());
    }

    public Stop createStop(String name, int estimate) {
        Stop stop = new Stop();
        stop.setName(name);
        stop.setEstimate(estimate);
        return stop;
    }
}
