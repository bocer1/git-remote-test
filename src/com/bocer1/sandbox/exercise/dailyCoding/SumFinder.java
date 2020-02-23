package com.bocer1.sandbox.exercise.dailyCoding;

import com.bocer1.lib.dataStruc.Pair;

import java.util.*;

public class SumFinder {
    public List<Pair<Integer, Integer>> find(final int target, final List<Integer> addendList) {
        final List<Pair<Integer, Integer>> result = new ArrayList<>();
        if(addendList != null && !addendList.isEmpty()) {
            final Set<Integer> trackingSet = new HashSet<>();
            addendList.forEach(addend -> {
                final int requiredPair = target - addend;
                if(trackingSet.contains(requiredPair)) {
                    result.add(new Pair<>(requiredPair, addend));
                } else {
                    trackingSet.add(addend);
                }
            });
        }

        return result;
    }
}
