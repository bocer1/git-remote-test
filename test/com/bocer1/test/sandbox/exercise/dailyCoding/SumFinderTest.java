package com.bocer1.test.sandbox.exercise.dailyCoding;

import com.bocer1.lib.dataStruc.Pair;
import com.bocer1.sandbox.exercise.dailyCoding.SumFinder;
import com.bocer1.sandbox.interview.stripe.MaxFieldCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumFinderTest {
    @Test
    public void HappyPathTest() {
        final int target = 17;
        final List<Integer> addendList = new ArrayList<Integer>(){{
            add(10);
            add(15);
            add(3);
            add(5);
            add(7);
            add(12);
            add(4);
        }};

        final SumFinder sf = new SumFinder();
        final List<Pair<Integer, Integer>> result = sf.find(target, addendList);
        assertEquals(2, result.size(), "There should be 2 pairs on the data set");
        for(Pair<Integer, Integer> p : result) {
            assertEquals(17, p.getX() + p.getY());
        }
    }

    @Test
    public void noPairTest() {
        final int target = 17;
        final List<Integer> addendList = new ArrayList<Integer>(){{
            add(80);
            add(75);
            add(3);
            add(5);
            add(7);
            add(32);
            add(4);
        }};

        final SumFinder sf = new SumFinder();
        final List<Pair<Integer, Integer>> result = sf.find(target, addendList);
        assertEquals(0, result.size(), "There should be 0 pairs on the data set");
    }

    @Test
    public void emptyInputTest() {
        final int target = 17;
        final List<Integer> addendList = new ArrayList<Integer>();

        final SumFinder sf = new SumFinder();
        final List<Pair<Integer, Integer>> result = sf.find(target, addendList);
        assertEquals(0, result.size(), "There should be 0 pairs on the data set");
    }
}