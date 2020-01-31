/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;

/**
 *
 * @author k
 */
public class OptimalRoute {
    private List<Connection> connections=new ArrayList<>();
    private int time=0;
    
    public void addConnection(Connection c) {
        connections.add(c);
    }
    public void addTime(int t) {
        time+=t;
    }
    public int getTime() {
        return time;
    }
    public List<Connection> getConnections() {
        Collections.reverse(connections);
        return connections;
    }
    
    public String toString() {
        Collections.reverse(connections);
        String ret="";
        for(Connection c: connections) {
            ret+=" ["+c.getDepartureStop()+ " - "+ c.getTargetStop() +"] ";
        }
        ret += " on time " +  time;
        return ret;
    }
    
}