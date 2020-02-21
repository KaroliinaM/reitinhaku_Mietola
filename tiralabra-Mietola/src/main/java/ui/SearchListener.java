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
import java.util.HashMap;
import javax.swing.JComboBox;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;

/**
 *
 * @author k
 */
public class SearchListener implements ActionListener {

    //private JTextField departure;
    private JComboBox departure;
    private JComboBox target;
    private JLabel outputList;
    public AstarRouteFinder astarfinder;
    public DijkstraRoutefinder dijkstrafinder;
    public HashMap<String, Stop> stopList;

    public void addInputFields(JComboBox departure, JComboBox target) {
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

    public void addStoplist(HashMap<String, Stop> stopList) {
        this.stopList = stopList;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Stop dep = stopList.get(departure.getSelectedItem());
        System.out.println(dep.getGtfsId());
        System.out.println(stopList.get(target.getSelectedItem()).getGtfsId());
        OptimalRoute route = astarfinder.search(stopList.get(departure.getSelectedItem())
                .getGtfsId(),
                stopList.get(target.getSelectedItem()).getGtfsId(), 0);
        outputList.setText(route.toUiString());
    }
}
