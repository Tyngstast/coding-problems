package com.henrj.codingproblems;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestSubstringProblem {

    int lengthOfLongestSubstring(String s) throws IllegalArgumentException{
        if (s == null || s.length() == 0) throw new IllegalArgumentException("Invalid string");
        int len = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; i < len; i++) {
            Character c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null) {
                j = Math.max(index, j);
            }
            result = Math.max(result, i - j + 1);
            map.put(c, i + 1);
        }
        return result;
    }
}
