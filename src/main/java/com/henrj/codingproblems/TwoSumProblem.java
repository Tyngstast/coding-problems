package com.henrj.codingproblems;

import java.util.HashMap;
import java.util.Map;

class TwoSumProblem {

    int[] twoSum(int[] values, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            Integer compIndex = complements.get(values[i]);
            if (compIndex != null) {
                return new int[]{compIndex, i};
            } else {
                complements.put(target - values[i], i);
            }
        }
        return null;
    }
}
