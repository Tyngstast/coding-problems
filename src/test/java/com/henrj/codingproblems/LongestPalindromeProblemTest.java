package com.henrj.codingproblems;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LongestPalindromeProblemTest {

    private final LongestPalindromeProblem solution = new LongestPalindromeProblem();

    @Test
    void longestPalindrome() {
        assertThat(solution.longestPalindrome("babad")).isEqualTo("aba");
        assertThat(solution.longestPalindrome("cbcb")).isEqualTo("bcb");
        assertThat(solution.longestPalindrome("bbb")).isEqualTo("bbb");
        assertThat(solution.longestPalindrome("b")).isEqualTo("b");
    }
}
