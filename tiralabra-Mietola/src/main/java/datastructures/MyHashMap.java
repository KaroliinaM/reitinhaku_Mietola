/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import data.Stop;
import utils.HashFunction;

/**
 * HashMap structure. Stores stop objects with a string key
 *
 * @author k
 */
public class MyHashMap {

    HashFunction hasher = new HashFunction();
    private int n = 10000;
    private MyArrayList[] entries = new MyArrayList[n];

    public MyHashMap(HashFunction function) {
        hasher = function;
        for (int i = 0; i < n; i++) {
            entries[i] = new MyArrayList();
        }
    }

    /**
     * Add an entry to the hashmap
     *
     * @param key String
     * @param value Stop object
     */
    public void put(String key, Stop value) {
        MyArrayList selected = entries[hasher.polynomialHash(key, n)];
        int entryIndex = getExistingIndex(key, selected);
        if (entryIndex > -1) {
            selected.removeObject(entryIndex);
        }
        selected.insertObject(new Entry(key, value));

    }

    /**
     * get a stop object that is stored with a specified key
     * @param key String
     * @return Stop object
     */
    public Stop get(String key) {
        MyArrayList entriesWithKey = entries[hasher.polynomialHash(key, n)];
        int entryIndex = getExistingIndex(key, entriesWithKey);
        if (entryIndex < 0) {
            return null;
        }
        Entry entry = (Entry) entriesWithKey.getObject(entryIndex);
        return entry.getValue();
    }

    /**
     * Hash function from Tirakirja.
     *
     * @param s String to be hashed.
     */
    /*  private int hashString(String s) {
        int h=0;
        for(int i=0; i<s.length(); i++) {
            h=(h*s.length()+ (int)s.charAt(i))%n;
        }
        return h;
    }**/
    private int getExistingIndex(String key, MyArrayList entriesWithKey) {
        for (int i = 0; i < entriesWithKey.returnObjLength(); i++) {
            Entry entry = (Entry) entriesWithKey.getObject(i);
            if (entry.getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
