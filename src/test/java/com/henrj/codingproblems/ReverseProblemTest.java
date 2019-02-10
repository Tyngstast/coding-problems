package com.henrj.codingproblems;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseProblemTest {

    private final ReverseProblem reverseProblem = new ReverseProblem();

    @Test
    void reverse() {
        assertThat(reverseProblem.reverse(123)).isEqualTo(321);
        assertThat(reverseProblem.reverse(-572)).isEqualTo(-275);
        // NumberFormatException
        assertThat(reverseProblem.reverse(1534236469)).isEqualTo(0);
        assertThat(reverseProblem.reverse(600)).isEqualTo(6);
    }
}
