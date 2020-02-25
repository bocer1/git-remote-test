package com.bocer1.sandbox.exercise.euler;

import com.bocer1.lib.algo.math.MathUtil;

/**
 * Problem statement:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
    public static void main(String[] args) {
        System.out.println(solve2(1000000000000L, 3, 5));
        System.out.println(Long.MAX_VALUE);
    }

    private static long solve(final long upperBound, final long ... bases) {
        long sum = 0;
        for(long base : bases) {
            final long partialSum = getPartialSum(base, upperBound);
            sum += partialSum;
        }

        long lcm = MathUtil.getLCM(1L, 1L, bases);
        return sum - getPartialSum(lcm, upperBound);
    }

    private static long getPartialSum(long base, long upperBound) {
        final long nthTerm = MathUtil.getMaxMultiple(base, upperBound);
        return MathUtil.getArithmeticSeriesPartialSum(base, nthTerm, base);
    }

    private static long solve2(final long upperBound, final long ... bases) {
        long min = Integer.MAX_VALUE;
        for(long base : bases) {
            if (base < min) {
                min = base;
            }
        }

        long sum = 0;
        for(long i = min; i < upperBound; i++) {
            if(isDivisible(i, bases)) {
                sum += i;
            }
        }

        return sum;
    }

    private static boolean isDivisible(final long num, final long ... bases) {
        for(long base : bases) {
            if(num % base == 0) {
                return true;
            }
        }

        return false;
    }
}
