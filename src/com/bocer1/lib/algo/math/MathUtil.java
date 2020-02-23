package com.bocer1.lib.algo.math;

public class MathUtil {
    public static int getGCF(int m, int n) {
        if(m > n) {
            return getOrderedGCF(m, n);
        }

        return getOrderedGCF(n, m);
    }

    private static int getOrderedGCF(final int m, final int n) {
        int r = m % n;

        if (r == 0) {
            return n;
        }

        return getOrderedGCF(n, r);
    }
}