/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 * Hash function for hashmap and hashset.
 *
 * @author k
 */
public class HashFunction {

    public int polynomialHash(String s, int n) {
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (h * s.length() + (int) s.charAt(i)) % n;
        }
        return h;
    }
}
