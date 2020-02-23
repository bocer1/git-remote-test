package com.bocer1.test.sandbox.interview.stripe;

import com.bocer1.sandbox.interview.stripe.MaxFieldCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MaxFieldValueTest {
    @Test
    public void max() {
        List<Map<String, Double>> input = new ArrayList<Map<String, Double>>() {{
                add(new LinkedHashMap<String, Double>() {{ put("A", 100d); put("B", 50d); put("C", 80d);               }});
                add(new LinkedHashMap<String, Double>() {{ put("A", 200d); put("B", 70d);                              }});
                add(new LinkedHashMap<String, Double>() {{ put("A",  10d);                put("C", 99d);               }});
                add(new LinkedHashMap<String, Double>() {{ put("A", 100d);                               put("D", 25d);}});
        }};

        MaxFieldCalculator m = new MaxFieldCalculator();
        Map<String, Double> result = m.max(input);
        assertEquals(200d, result.get("A").doubleValue());
        assertEquals(70d,  result.get("B").doubleValue());
        assertEquals(99d,  result.get("C").doubleValue());
        assertEquals(25d,  result.get("D").doubleValue());
    }
}