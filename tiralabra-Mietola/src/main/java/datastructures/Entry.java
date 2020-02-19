/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import data.Stop;

/**
 *
 * @author k
 */
public class Entry {

    private String key;
    private Stop value;

    public Entry(String key, Stop value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public Stop getValue() {
        return this.value;
    }
}
