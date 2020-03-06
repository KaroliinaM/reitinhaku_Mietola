/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.io.Serializable;

/**
 * Implementation of a ArrayList. Can be used to store Strings, Integers and
 * Objects
 *
 * @author k
 */
public class MyArrayList implements Serializable {

    int[] integers = new int[50];
    String[] strings = new String[50];
    Object[] objects = new Object[50];
    int intPointer = 0;
    int stringPointer = 0;
    int objectPointer = 0;

    /**
     * insert an integer to the list
     *
     * @param integer the integer to be stored
     */
    public void insertInt(int integer) {
        if (intPointer == integers.length) {
            int[] newInts = new int[integers.length + 50];
            for (int i = 0; i < integers.length; i++) {
                newInts[i] = integers[i];
            }
            integers = newInts;
        }
        integers[intPointer] = integer;
        intPointer++;
    }

    /**
     * insert a String to the list.
     *
     * @param String
     */
    public void insertString(String newString) {
        if (stringPointer == strings.length) {
            String[] newStrings = new String[strings.length + 50];
            for (int i = 0; i < strings.length; i++) {
                newStrings[i] = strings[i];
            }
            strings = newStrings;
        }
        strings[stringPointer] = newString;
        stringPointer++;
    }

    /**
     * insert an object to the list
     *
     * @param object
     */
    public void insertObject(Object object) {
        if (objectPointer == objects.length) {
            Object[] newObjects = new Object[objects.length + 50];
            for (int i = 0; i < objects.length; i++) {
                newObjects[i] = objects[i];
            }
            objects = newObjects;
        }
        objects[objectPointer] = object;
        objectPointer++;
    }

    /**
     * get a string from the list
     *
     * @param i index of the string
     * @return String
     */
    public String getString(int i) {
        return this.strings[i];
    }

    /**
     * get a nteger value from the list
     *
     * @param i index of the integer
     * @return the integer
     */
    public int getInt(int i) {
        return this.integers[i];
    }

    /**
     * return a object from the list
     *
     * @param i index of the object
     * @return object
     */
    public Object getObject(int i) {
        return this.objects[i];
    }

    /**
     * remove an object from the list
     *
     * @param x index of the object
     */
    public void removeObject(int x) {
        for (int i = x; i < this.objects.length - 1; i++) {
            this.objects[i] = this.objects[i + 1];
        }
        objectPointer--;
    }

    /**
     * remove a string from the list
     *
     * @param x index of the string
     */
    public void removeString(int x) {
        for (int i = x; i < strings.length - 1; i++) {
            strings[i] = strings[i + 1];
        }
        stringPointer--;
    }

    /**
     * return the amount of integers
     *
     * @return int
     */
    public int returnIntLength() {
        return intPointer;
    }

    /**
     * return the amount of string
     *
     * @return int
     */
    public int returnStringLength() {
        return stringPointer;
    }

    /**
     * return the amount of objects on the list
     *
     * @return int
     */
    public int returnObjLength() {
        return objectPointer;
    }

    /**
     * reverse list order
     */
    public void reverseObject() {
        for (int i = 0; i < this.objectPointer / 2; i++) {
            Object temp = objects[i];
            objects[i] = objects[this.objectPointer - 1 - i];
            objects[this.objectPointer - 1 - i] = temp;
        }
    }

}
