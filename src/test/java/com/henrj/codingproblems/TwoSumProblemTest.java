package com.henrj.codingproblems;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumProblemTest {

    private final TwoSumProblem solution = new TwoSumProblem();

    @Test
    void twoSum() {
        int[] values = new int[]{2, 4, 5, 15};
        int target = 9;
        Assertions.assertThat(solution.twoSum(values, target)).isEqualTo(new int[]{1, 2});
    }
}
