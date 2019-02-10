package com.henrj.codingproblems;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LengthOfLongestSubstringProblemTest {

    private final LengthOfLongestSubstringProblem solution = new LengthOfLongestSubstringProblem();

    @Test
    void lengthOfLongestSubstring() {
        assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(solution.lengthOfLongestSubstring("absasdvb")).isEqualTo(5);
        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstring("c")).isEqualTo(1);
        assertThat(solution.lengthOfLongestSubstring("aab")).isEqualTo(2);
        assertThatThrownBy(() -> solution.lengthOfLongestSubstring(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> solution.lengthOfLongestSubstring("")).isInstanceOf(IllegalArgumentException.class);
    }
}
