package com.bocer1.sandbox.algo.math;

public class MathUtil {
    public static int getGCF(int m, int n) {
        int r = m % n;

        if (r == 0) {
            return n;
        }

        return getGCF(n, r);
    }
}