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
      //  System.out.println(time2);
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
    
    @Test
    public void getDistanceTimes() {
        Stop d = createStop(60.259, 24.81846);
        Stop g = createStop(60.20583, 24.96293);
        
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 29);
        
        d = createStop(60.1652, 24.95261);
        g = createStop(60.31977, 25.05094);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 54);
        
        d = createStop(60.32917, 24.64737);
        g = createStop(60.212913, 25.139195);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 90);
        
        d = createStop(60.22155, 24.80653);
        g = createStop(60.151748, 24.646597);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 35);
        
        d = createStop(60.451385, 24.97701);
        g = createStop(60.34795, 24.87113);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 38);
        
        d = createStop(60.155789, 24.714964);
        g = createStop(60.22493, 24.97096);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 48);
        
        d = createStop(60.188759, 24.396284);
        g = createStop(60.38032, 25.08745);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 131);
        
        d = createStop(60.226347, 24.37974);
        g = createStop(60.390622, 25.235358);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 151);
        
        d = createStop(60.07481, 24.443197);
        g = createStop(60.288834, 21.439211);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 503);
        
        d = createStop(60.246229, 24.93838);
        g = createStop(60.237547, 24.987565);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 8);
        
        d = createStop(60.26832, 25.00157);
        g = createStop(60.29822, 24.96976);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 11);
        
        d = createStop(60.054922, 24.376973);
        g = createStop(60.21902, 24.81092);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 90);
        
        d = createStop(60.007402, 24.455442);
        g = createStop(60.19157, 24.91246);
        System.out.println(calculator.timeEstimate(d, g));
        assertEquals(calculator.timeEstimate(d, g), 97);

    }

    public Stop createStop(double lat, double lon) {
        Stop stop = new Stop();
        stop.setLat(lat);
        stop.setLon(lon);
        return stop;
    }
}
