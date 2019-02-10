package com.henrj.codingproblems;

import java.util.HashMap;
import java.util.Map;

public class CanJumpProblem {

    public static void main(String[] args) {
        CanJumpProblem canJumpProblem = new CanJumpProblem();
        System.out.println(canJumpProblem.canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJumpProblem.canJumpMinimalNumberOfJumps(new int[]{2,3,1,1,4}));
        System.out.println(canJumpProblem.canJumpMinimalNumberOfJumps(new int[]{1,1,1,1}));
        System.out.println(canJumpProblem.canJumpMinimalNumberOfJumps(new int[]{2,1}));
        System.out.println(canJumpProblem.canJumpMinimalNumberOfJumps(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
        System.out.println(canJumpProblem.canJumpMinimalNumberOfJumps(new int[]{1,2,3}));
    }

    private Map<Integer, Boolean> memo = new HashMap<>();

    private boolean canJump(int[] nums) {
        memo.put(nums.length-1, true);
        return canJumpFromPosition(nums, 0);
    }

    private boolean canJumpFromPosition(int[] nums, int position) {
        Boolean goodOrBad = memo.get(position);

        if (goodOrBad != null) {
            return goodOrBad;
        }

        int furthestJump = Math.min(nums.length - 1, position + nums[position]);

        for (int nextPos = furthestJump; nextPos > position; nextPos--) {
            if (canJumpFromPosition(nums, nextPos)) {
                memo.put(position, true);
                return true;
            }
        }

        memo.put(position, false);

        return false;
    }

    /**
     *  If we can find an index earlier in the array when doing bottom-up
     *  which gets us to our current positio -- and can do this all the way back to the beginning --
     *  then the result is true
     */
    boolean canJumpGreedy(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    private int canJumpMinimalNumberOfJumps(int[] nums) {
        int currentPos = 0;
        int jumps = 0;

        while (true) {
            if (currentPos >= nums.length-1) {
                return jumps;
            }
            if (nums[currentPos] == 0) {
                return 0;
            }
            currentPos = getNextOptimalStep(currentPos, nums);
            jumps++;
        }
    }

    private int getNextOptimalStep(int pos, int[] nums) {
        int maxSingleJump;
        int maxTotal;
        int optimalNextPos;

        // Math.min to not jump out of bounds
        maxSingleJump = maxTotal = optimalNextPos = Math.min(nums[pos], nums.length-1);

        for (int i = Math.min(pos + maxSingleJump, nums.length-1); i > pos; i--) {
            if (i + nums[i] > maxTotal) {
                maxTotal = i + nums[i];
                optimalNextPos = i;
                // Do not keep looking for optimal jump if we can reach the end
                if (maxTotal >= nums.length-1) {
                    break;
                }
            }
        }
        return optimalNextPos;
    }

}
