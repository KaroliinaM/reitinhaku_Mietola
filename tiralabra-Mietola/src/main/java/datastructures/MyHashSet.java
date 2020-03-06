/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import utils.HashFunction;

/**
 * A hashset implementation.
 * @author k
 */
public class MyHashSet {
    
    private int n = 10000;
    private MyArrayList[] entries = new MyArrayList[n];
    private HashFunction hashfunction;
    
    public MyHashSet(HashFunction function) {
        hashfunction = function;
        for (int i = 0; i < n; i++) {
            entries[i] = new MyArrayList();
        }
    }
    
    public void add(String s) {
        MyArrayList entryList = entries[hashfunction.polynomialHash(s, n)];
        int ifExist = getEntryIndex(s, entryList);
        if (ifExist < 0) {
            entryList.insertString(s);
        }
    }
    
    public boolean contains(String s) {
        MyArrayList entryList = entries[hashfunction.polynomialHash(s, n)];
        boolean exist = getEntryIndex(s, entryList) > -1;
        return exist;
    }
    
    public void remove(String s) {
        MyArrayList entryList = entries[hashfunction.polynomialHash(s, n)];
        int entry = getEntryIndex(s, entryList);
        entryList.removeString(entry);
    }
    
    public int getEntryIndex(String s, MyArrayList list) {
        for (int i = 0; i < list.returnStringLength(); i++) {
            if (list.getString(i).equals(s)) {
                return i;
            }
        }
        return -1;
    }
    
}
