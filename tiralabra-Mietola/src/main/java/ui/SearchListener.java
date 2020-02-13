/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.Connection;
import data.OptimalRoute;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;

/**
 *
 * @author k
 */
public class SearchListener implements ActionListener {

    private JTextField departure;
    private JTextField target;
    private JLabel outputList;
    public AstarRouteFinder astarfinder;
    public DijkstraRoutefinder dijkstrafinder;

    public void addInputFields(JTextField departure, JTextField target) {
        this.departure = departure;
        this.target = target;
    }

    public void addTargetList(JLabel outputList) {
        this.outputList = outputList;
    }

    public void addRouteFinder(DijkstraRoutefinder finder) {
        this.dijkstrafinder = finder;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        OptimalRoute route = dijkstrafinder.search(departure.getText(), target.getText(), 0);
        outputList.setText(route.toUiString());
    }
}
