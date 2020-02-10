/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import api.ExecuteQuery;
import data.Stop;
import java.util.*;
import network.Mapdata;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;
import utils.DistanceCalculator;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k
 */
public class FinderUI implements Runnable {
    
    private JFrame frame;

    /**
     * Doesn't work as UI, because cmd readers don't work. Going to look into it
     * next week. Gets the data, sets it into the map and then does the search.
     * Prints out only the stop id:s, got to make it more informative.
     */
    public void run() {

    }
    
    public void runUI() {
        frame = new JFrame("otsikko");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createUIComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    public void createUIComponents(Container container) {
        GridLayout layout=new GridLayout(4, 2);
        container.setLayout(layout);
        createLabel("Reittiopas", container);
        createLabel("", container);
        createLabel("Lähtöpysäkki", container);
        JTextField departureStop=new JTextField();
        container.add(departureStop);
        createLabel("kohdepysäkki", container);
        JTextField targetStop=new JTextField();
        container.add(targetStop);
        createLabel("", container);
        JButton searchRoute= new JButton("Hae reitti");
        SearchListener listener=new SearchListener();
        searchRoute.addActionListener(listener);
        container.add(searchRoute);
   //     JList stopList=new JList();
   //     container.add(stopList);
        
    }
    public void createLabel(String text, Container container) {
        JLabel label=new JLabel(text);
        container.add(label);
    }
    
}
