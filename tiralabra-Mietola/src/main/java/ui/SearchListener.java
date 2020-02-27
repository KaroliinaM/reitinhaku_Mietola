/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import data.Connection;
import data.OptimalRoute;
import data.Stop;
import datastructures.MyArrayList;
import java.util.HashMap;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;
import utils.PerformanceTest;

/**
 *
 * @author k
 */
public class SearchListener implements ActionListener {

    //private JTextField departure;
    private JComboBox departure;
    private JComboBox target;
    private JRadioButton dijkstra;
    private JRadioButton astar;
    private JLabel outputList;
    public AstarRouteFinder astarfinder;
    public DijkstraRoutefinder dijkstrafinder;
    public HashMap<String, Stop> stopList;
    Mapdata mapdata = new Mapdata();
    private MyArrayList stopdata;
    JTextField hours;
    JTextField minutes;
    JCheckBox tests;
    PerformanceTest performancetest;

    public void addInputFields(JComboBox departure, JComboBox target, 
        JTextField hours, JTextField minutes, JRadioButton dijkstra, JRadioButton astar, JCheckBox tests) {
        this.departure = departure;
        this.target = target;
        this.hours = hours;
        this.minutes = minutes;
        this.dijkstra=dijkstra;
        this.astar=astar;
        this.tests=tests;
    }

    public void addTargetList(JLabel outputList) {
        this.outputList = outputList;
    }

    public void addRouteFinders(DijkstraRoutefinder dijkstraFinder, 
            AstarRouteFinder astarFinder) {
        this.dijkstrafinder = dijkstraFinder;
        this.astarfinder = astarFinder;
    }

    public void addStoplist(HashMap<String, Stop> stopList) {
        this.stopList = stopList;
    }
    
    public void addTest(PerformanceTest test) {
        this.performancetest = test;
    }

    public void addStopData(MyArrayList stopdata) {
        this.stopdata = stopdata;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        outputList.setText("Haetaan...");
        mapdata.setStops(stopdata);
        if(tests.isSelected()) performancetest.run();

        

        Stop dep = stopList.get(departure.getSelectedItem());
        System.out.println(dep.getGtfsId());
        System.out.println(stopList.get(target.getSelectedItem()).getGtfsId());
        System.out.println(Integer.parseInt(hours.getText()));
        System.out.println(Integer.parseInt(minutes.getText()));

        int time = (Integer.parseInt(hours.getText()) * 3600) + 
                (Integer.parseInt(minutes.getText()) * 60);
        System.out.println(time);
        OptimalRoute route=null;
        if(astar.isSelected()) {
            astarfinder.setMapdata(mapdata);
            route = astarfinder.search(stopList.get(departure.getSelectedItem())
                .getGtfsId(),
                stopList.get(target.getSelectedItem()).getGtfsId(), time);
        } else {
           dijkstrafinder.setMapdata(mapdata);
            route = dijkstrafinder.search(stopList.get(departure.getSelectedItem())
                .getGtfsId(),
                stopList.get(target.getSelectedItem()).getGtfsId(), time); 
        }
        
        outputList.setText(route.toUiString());
    }
}
