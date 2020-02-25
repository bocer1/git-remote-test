package com.bocer1.lib.algo.math;

public class MathUtil {
    /**
     * Retrieves the greatest common factor (GCF) of 2 or more numbers. Must have at least
     * 2 inputs to be able to run this function.
     *
     * Negative inputs are treated as if they are positive numbers. The rationale behind that
     * is that if we have a number n whose factors are 1, f<sub>1</sub>, f<sub>2</sub>, ..., f<sub>n</sub>
     * then negative n would have -1, 1, f<sub>1</sub>, f<sub>2</sub>, ..., f<sub>n</sub> as its factors.
     * The GCF of both n and -n is one of those factors in 1, f<sub>1</sub>, f<sub>2</sub>, ..., f<sub>n</sub>
     *
     * @param p One of the numbers to get the GCF from
     * @param q One of the numbers to get the GCF from
     * @param r Optional numbers to get the GCF from
     * @return The GCF of the given numbers
     */
    public static long getGCF(final long p, final long q, final long ... r) {
        long gcf = getUnorderedGCF(Math.abs(p), Math.abs(q));
        for(long s : r) {
            gcf = getUnorderedGCF(Math.abs(s), gcf);
        }

        return gcf;
    }

    private static long getUnorderedGCF(long p, long q) {
        if(p > q) {
            return getOrderedGCF(p, q);
        }

        return getOrderedGCF(q, p);
    }

    private static long getOrderedGCF(final long m, final long n) {
        long r = m % n;

        if (r == 0) {
            return n;
        }

        return getOrderedGCF(n, r);
    }

    /**
     * Retrieves the least common multiple of 2 or more numbers.
     * @param p One of the inputs for retrieving LCM
     * @param q One of the inputs for retrieving LCM
     * @param r Optional inputs for retrieving LCM
     * @return The LCM of the given numbers
     */
    public static long getLCM(final long p, final long q, final long ... r) {
        long product = p * q;
        for(long n : r) {
            product *= n;
        }

        long gcf = getGCF(p, q, r);

        return product / gcf;
    }

    /**
     * Retrieves the number of terms in an arithmetic sequence given the first term and the nth term
     * and the common difference between terms (the delta). The first term should be smaller than the
     * last term when delta is positive. Conversely, the first term must be larger than the last term
     * when the delta is negative. Also, the difference between the first term and the last term
     * must be a multiple of the delta. Otherwise, it would not be considered as an arithmetic sequence.
     * If the delta is zero, while a valid arithmetic sequence, the number of terms between the first
     * and the last term is indeterminate as each term on the sequence is the same.
     * @param firstTerm The first term of the arithmetic sequence (lower bound)
     * @param nthTerm The nth term of the arithmetic sequence
     * @param delta The common difference between each term.
     * @return The number of terms between the first and nth term (including the first and nth term).
     */
    public static long getArithmeticSequenceTermCount(final long firstTerm, final long nthTerm, final long delta) {
        if(delta == 0) {
            throw new ArithmeticException("The number of terms for an arithmetic series with delta = 0 is indeterminate.");
        } else if (delta > 0 && firstTerm > nthTerm) {
            throw new ArithmeticException("The nth term must be bigger than the last term as the delta is a positive number. firstTerm = " + firstTerm + ", nthTerm = " + nthTerm + ", delta = " + delta);
        } else if (delta < 0 && firstTerm < nthTerm) {
            throw new ArithmeticException("The nth term must be smaller than the last term as the delta is a negative number.");
        }

        final long diff = nthTerm - firstTerm;
        final long remainder = diff % delta;
        if(remainder > 0) {
            throw new ArithmeticException("Not a valid arithmetic sequence as the difference between the first term and the nth term is not a multiple of the delta");
        }

        return diff/delta + 1;
    }

    /**
     *
     * @param firstTerm
     * @param nthTerm
     * @param delta
     * @return
     */
    public static long getArithmeticSeriesPartialSum(final long firstTerm, final long nthTerm, final long delta) {
        final long n = getArithmeticSequenceTermCount(firstTerm, nthTerm, delta);
        return n * (firstTerm + nthTerm) / 2;
    }

    public static long getMaxMultiple(final long base, final long upperBound) {
        for(long i = upperBound - 1; i > 0; i--) {
            if(i%base == 0) {
                return i;
            }
        }

        throw new IllegalArgumentException("The values don't converge.");
    }
}