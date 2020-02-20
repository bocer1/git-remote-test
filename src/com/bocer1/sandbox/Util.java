package com.bocer1.sandbox;

import java.math.BigDecimal;

public class Util {
    public static int add(Integer... addends) {
        int sum = 0;
        if(addends != null && addends.length > 0) {
            for (int addend : addends) {
                sum += addend;
            }
        }

        return sum;
    }
}
