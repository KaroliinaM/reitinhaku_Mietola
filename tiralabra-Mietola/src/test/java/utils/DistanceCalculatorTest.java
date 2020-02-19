/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import data.Stop;

/**
 *
 * @author k
 */
public class DistanceCalculatorTest {

    DistanceCalculator calculator;

    public DistanceCalculatorTest() {
    }

    @Before
    public void setUp() {
        calculator = new DistanceCalculator();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getDistance() {
        double travel = calculator.distFrom(60.19152, 24.92539, 60.1926, 24.93078);
        assertEquals(321.00, travel, 1);
        double travel2 = calculator.distFrom(60.19803, 24.93425, 60.20488, 24.96385);
        assertEquals(1804, travel2, 1);
    }

    @Test
    public void getTimeForDistance() {
        int time = calculator.timeForDist(20000);
        assertEquals(time, 60);
        int time2 = calculator.timeForDist(1804);
        assertEquals(time2, 5);
        System.out.println(time2);
    }

    @Test
    public void getDistanceTraveTime() {
        //pasila-kumpula
        Stop first = createStop(60.19803, 24.93425);
        Stop second = createStop(60.20488, 24.96385);
        int time = calculator.timeEstimate(first, second);
        assertEquals(time, 5);
        //pitäjänmäki-itäkeskus
        Stop three = createStop(60.22325, 24.860594);
        Stop four = createStop(60.209231, 25.079047);
        int time2 = calculator.timeEstimate(three, four);
        assertEquals(time2, 36);
    }

    public Stop createStop(double lat, double lon) {
        Stop stop = new Stop();
        stop.setLat(lat);
        stop.setLon(lon);
        return stop;
    }
}
