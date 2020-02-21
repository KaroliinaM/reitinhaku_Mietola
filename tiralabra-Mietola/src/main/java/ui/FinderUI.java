/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import api.ExecuteQuery;
import data.Stop;
import datastructures.MyArrayList;
import javax.swing.JComboBox;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;
import utils.DistanceCalculator;

/**
 *
 * @author k
 */
public class FinderUI implements Runnable {

    private JFrame frame;
    private DijkstraRoutefinder dijkstrafinder;
    private AstarRouteFinder astarfinder;
    private SearchListener listener = new SearchListener();
    HashMap<String, Stop> stopnames;
    MyArrayList stopdata;

    /**
     * a swing UI, in progress. The output is printed on the console.
     */
    public void run() {

    }

    public void runUI(HashMap<String, Stop> stopnames, MyArrayList stopdata) {
        this.stopdata = stopdata;
        this.stopnames = stopnames;
        frame = new JFrame("otsikko");
        frame.setPreferredSize(new Dimension(800, 1000));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createUIComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createUIComponents(Container container) {
        container.add(createInputPanel(), BorderLayout.NORTH);
        container.add(createList(), BorderLayout.CENTER);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(5, 2);
        panel.setLayout(layout);
        createLabel("Reittiopas", panel);
        createLabel("", panel);
        createLabel("Lähtöpysäkki", panel);
        //JTextField departureStop = new JTextField();
        JComboBox departureStop = new JComboBox(stopnames.keySet().toArray());
        departureStop.setEditable(true);
        panel.add(departureStop);
        createLabel("kohdepysäkki", panel);
        JComboBox targetStop = new JComboBox(stopnames.keySet().toArray());
        //  JTextField targetStop = new JTextField();
        panel.add(targetStop);
        createLabel("lähtöaika", panel);
        JPanel timepanel = new JPanel();
        GridLayout timelayout = new GridLayout(1, 2);
        timepanel.setLayout(timelayout);
        JTextField hours = new JTextField("0");
        timepanel.add(hours);
        JTextField minutes = new JTextField("0");
        timepanel.add(minutes);
        panel.add(timepanel);
        createLabel("", panel);
        JButton searchRoute = new JButton("Hae reitti");
        listener.addInputFields(departureStop, targetStop, hours, minutes);
        listener.addStoplist(stopnames);
        listener.addStopData(stopdata);
        listener.addRouteFinders(dijkstrafinder, astarfinder);
        searchRoute.addActionListener(listener);
        panel.add(searchRoute);
        return panel;
    }

    private JPanel createList() {
        JPanel panel = new JPanel();
        JLabel list = new JLabel();
        listener.addTargetList(list);
        panel.add(list, BorderLayout.CENTER);
        return panel;
    }

    private void createLabel(String text, Container container) {
        JLabel label = new JLabel(text);
        container.add(label);
    }

    public void setAlgorithms(DijkstraRoutefinder dikstrafinder, AstarRouteFinder astarfinder) {
        this.dijkstrafinder = dikstrafinder;
        this.astarfinder = astarfinder;
    }

}
