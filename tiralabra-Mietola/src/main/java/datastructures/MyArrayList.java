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

    public String getString(int i) {
        return this.strings[i];
    }

    public int getInt(int i) {
        return this.integers[i];
    }

    public Object getObject(int i) {
        return this.objects[i];
    }

    public void removeObject(int x) {
        for (int i = x; i < this.objects.length - 1; i++) {
            this.objects[i] = this.objects[i + 1];
        }
        objectPointer--;
    }

    public void removeString(int x) {
        for (int i = x; i < strings.length - 1; i++) {
            strings[i] = strings[i + 1];
        }
        stringPointer--;
    }

    public int returnIntLength() {
        return intPointer;
    }

    public int returnStringLength() {
        return stringPointer;
    }

    public int returnObjLength() {
        return objectPointer;
    }

    public void reverseObject() {
        for (int i = 0; i < this.objectPointer / 2; i++) {
            Object temp = objects[i];
            objects[i] = objects[this.objectPointer - 1 - i];
            objects[this.objectPointer - 1 - i] = temp;
        }
    }

}
