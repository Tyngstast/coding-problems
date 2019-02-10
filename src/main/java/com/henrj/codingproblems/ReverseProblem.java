package com.henrj.codingproblems;

class ReverseProblem {

    int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            x = Math.abs(x);
            negative = true;
        }
        String s = String.valueOf(x);
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        try {
            return negative ? - new Integer(result.toString()) : new Integer(result.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
