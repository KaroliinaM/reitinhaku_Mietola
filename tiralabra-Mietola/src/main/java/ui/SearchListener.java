/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import routefinder.AstarRouteFinder;
import routefinder.DijkstraRoutefinder;

/**
 *
 * @author k
 */
public class SearchListener implements ActionListener{
    public String departure;
    public String target;
    public AstarRouteFinder astarfinder;
    public DijkstraRoutefinder dijkstrafinder;
    
    public void addRouteFinder(DijkstraRoutefinder finder) {
        this.dijkstrafinder=finder;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("painettu nappia");
    }
    
}
