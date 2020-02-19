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

    public void addRouteFinders(DijkstraRoutefinder dijkstraFinder, AstarRouteFinder astarFinder) {
        this.dijkstrafinder = dijkstraFinder;
        this.astarfinder = astarFinder;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        OptimalRoute route = astarfinder.search(departure.getText(), target.getText(), 0);
        outputList.setText(route.toUiString());
    }
}
