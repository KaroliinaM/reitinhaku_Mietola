/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author k
 */
public class MathFunc {

    final double pi = 3.14159265358979323846;

    public double toRadians(double angdeg) {
        return angdeg / 180.0 * pi;
    }

    public float sin(double x) {
        float sin = 0.0f;
        long fact;
        for (int i = 1; i <= 10; i++) {
            fact = 1;
            for (int j = 1; j <= 2 * i - 1; j++) {
                fact = fact * j;
            }
            if (i % 2 == 1) {
                sin = sin + (float) (pow(x, 2 * i - 1) / fact);
            } else {
                sin = sin - (float) (pow(x, 2 * i - 1) / fact);
            }
        }
        return sin;
    }

    public double cos(double x) {
        int n = 30;
        double c = 1.0;
        double m = -1, r = 0, j = 1;
        for (int k = 2; k < n; k = k + 2) {
            double o = Math.pow(x, k);
            j = j * (k - 1) * k;
            r = o / j;
            c = c + m * r;
            m = m * (-1);

        }
        return c;
    }

    public double pow(double x, int y) {
        double ret = x;

        for (int i = 1; i < y; i++) {
            ret *= x;
        }
        return ret;
    }

    public double atan2(double x, double y) {
        double coeff_1 = Math.PI / 4d;
        double coeff_2 = 3d * coeff_1;
        double abs_y = Math.abs(y);
        double angle;
        if (x >= 0d) {
            double r = (x - abs_y) / (x + abs_y);
            angle = coeff_1 - coeff_1 * r;
        } else {
            double r = (x + abs_y) / (abs_y - x);
            angle = coeff_2 - coeff_1 * r;
        }
        return y < 0d ? -angle : angle;
    }

}
