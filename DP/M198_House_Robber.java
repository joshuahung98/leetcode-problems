/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping 
 * you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent 
 * houses were broken into on the same night. Given an integer array nums representing the amount of money of each house, return the maximum amount of
 * money you can rob tonight without alerting the police.
 * 
 * Really good explanation for reference: https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 * Runtime: O(n)
 * Space Complexity: O(1) 
 */
class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int twoAway = 0;
        int oneAway = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = oneAway;
            oneAway = Math.max(twoAway + nums[i], oneAway);
            twoAway = temp;
        }
        return oneAway;
    }
}