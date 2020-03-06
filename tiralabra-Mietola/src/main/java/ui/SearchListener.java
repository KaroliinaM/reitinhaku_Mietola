/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import data.Connection;
import data.OptimalRoute;
import data.Stop;
import datastructures.MyArrayList;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;
import utils.PerformanceTest;

/**
 *
 * @author k
 */
public class SearchListener implements ActionListener {

    private JTextField departure;
    private JTextField target;
    private JRadioButton dijkstra;
    private JRadioButton astar;
    private JLabel outputList;
    public AstarRouteFinder astarfinder;
    public DijkstraRoutefinder dijkstrafinder;
    Mapdata mapdata = new Mapdata();
    private MyArrayList stopdata;
    JTextField hours;
    JTextField minutes;
    JCheckBox tests;
    PerformanceTest performancetest;

    public void addInputFields(JTextField departure, JTextField target,
            JTextField hours, JTextField minutes, JRadioButton dijkstra,
            JRadioButton astar, JCheckBox tests) {
        this.departure = departure;
        this.target = target;
        this.hours = hours;
        this.minutes = minutes;
        this.dijkstra = dijkstra;
        this.astar = astar;
        this.tests = tests;
    }

    public void addTargetList(JLabel outputList) {
        this.outputList = outputList;
    }

    public void addRouteFinders(DijkstraRoutefinder dijkstraFinder,
            AstarRouteFinder astarFinder) {
        this.dijkstrafinder = dijkstraFinder;
        this.astarfinder = astarFinder;
    }

    public void addTest(PerformanceTest test) {
        this.performancetest = test;
    }

    public void addStopData(MyArrayList stopdata) {
        this.stopdata = stopdata;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        mapdata.setStops(stopdata);
        if (tests.isSelected()) {
            performancetest.run();
        }

        int time = (Integer.parseInt(hours.getText()) * 3600)
                + (Integer.parseInt(minutes.getText()) * 60);
        OptimalRoute route = null;
        if (departure.getText().length() > 0 && target.getText().length() > 0) {
            if (astar.isSelected()) {
                astarfinder.setMapdata(mapdata);
                route = astarfinder.search(departure.getText(),
                        target.getText(), time);
            } else {
                dijkstrafinder.setMapdata(mapdata);
                route = dijkstrafinder.search(departure.getText(),
                        target.getText(), time);
            }
            outputList.setText(route.toUiString());
        }
    }
}
