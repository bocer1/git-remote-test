package com.bocer1.test.lib.algo.math;

import com.bocer1.lib.algo.math.MathUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GCFTest {
    @Test
    void testGcfAllPrime() {
        assertEquals(1, MathUtil.getGCF(23, 11), "Prime numbers should have a GCF of 1");
        assertEquals(1, MathUtil.getGCF(5, 17), "Prime numbers should have a GCF of 1");
    }

    @Test
    void testGcfCompositeNoCommonFactors() {
        assertEquals(1, MathUtil.getGCF(81, 256), "81 and 256 have no common factors except 1");
        assertEquals(1, MathUtil.getGCF(125, 49), "125 and 49 have no common factors except 1");
    }

    @Test
    void testGcfOneInputFactorOfOther() {
        assertEquals(27, MathUtil.getGCF(81, 27), "GCF of 81 and 27 should be 27");
        assertEquals(5, MathUtil.getGCF(125, 5), "GCF of 125 and 5 should be 5");
        assertEquals(121, MathUtil.getGCF(121, 121), "GCF of 121 and 121 should be 121");
    }

    @Test
    void testGcfTwoInputsWithCommonFactors() {
        assertEquals(24, MathUtil.getGCF(120, 48), "GCF of 120 and 48 should be 24");
        assertEquals(18, MathUtil.getGCF(54, 90), "GCF of 54 and 90 should be 18");
        assertEquals(3, MathUtil.getGCF(57, 90), "GCF of 57 and 90 should be 3");
    }

    @Test
    void testGcfMultipleInputs() {
        assertEquals(24, MathUtil.getGCF(120, 48, 96, 168));
        assertEquals(8, MathUtil.getGCF(4096, 56, 800, 512));
    }

    @Test
    void testGcfNegativeNumbers() {
        assertEquals(5, MathUtil.getGCF(-15, 20));
        assertEquals(6, MathUtil.getGCF(12, -30));
        assertEquals(11, MathUtil.getGCF(-121, -55));
    }
}
