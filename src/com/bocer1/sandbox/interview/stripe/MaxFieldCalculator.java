package com.bocer1.sandbox.interview.stripe;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MaxFieldCalculator {
    public Map<String, Double> max(List<Map<String, Double>> input) {
        final Map<String, Double> result = new LinkedHashMap<>();
        input.forEach(stringDoubleMap -> {
            for(Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
                final String key = entry.getKey();
                if(result.containsKey(key)) {
                    Double currentMax = result.get(entry.getKey());
                    Double currentVal = entry.getValue();
                    if(currentMax < currentVal) {
                        result.replace(key, currentVal);
                    }
                } else {
                    result.put(key, entry.getValue());
                }
            }
        });

        return result;
    }
}
