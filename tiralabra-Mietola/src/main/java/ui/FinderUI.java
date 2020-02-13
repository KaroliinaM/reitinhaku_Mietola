/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import api.ExecuteQuery;
import data.Stop;
import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author k
 */
public class FinderUI implements Runnable {

    private JFrame frame;
    private DijkstraRoutefinder finder;
    private SearchListener listener = new SearchListener();

    /**
     * a swing UI, in progress. The output is printed on the console.
     */
    public void run() {

    }

    public void runUI() {
        frame = new JFrame("otsikko");
        frame.setPreferredSize(new Dimension(800, 800));
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
        GridLayout layout = new GridLayout(4, 2);
        panel.setLayout(layout);
        createLabel("Reittiopas", panel);
        createLabel("", panel);
        createLabel("Lähtöpysäkki", panel);
        JTextField departureStop = new JTextField();
        panel.add(departureStop);
        createLabel("kohdepysäkki", panel);
        JTextField targetStop = new JTextField();
        panel.add(targetStop);
        createLabel("", panel);
        JButton searchRoute = new JButton("Hae reitti");
        listener.addInputFields(departureStop, targetStop);
        listener.addRouteFinder(finder);
        searchRoute.addActionListener(listener);
        panel.add(searchRoute);
        return panel;
    }

    private JPanel createList() {
        JPanel panel = new JPanel();
        String[] paivat = new String[100];
        JList list = new JList(paivat);
        listener.addTargetList(paivat);
        panel.add(list, BorderLayout.CENTER);
        return panel;
    }

    private void createLabel(String text, Container container) {
        JLabel label = new JLabel(text);
        container.add(label);
    }

    public void setAlgorithm(DijkstraRoutefinder finder) {
        this.finder = finder;
    }

}
