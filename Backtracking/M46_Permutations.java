/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Runtime: O(2^n)
 * Space complexity: O(n)
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<>());
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, int[] nums, List<Integer> curList) {
        if(nums.length == curList.size()) {
            result.add(new ArrayList<>(curList));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(curList.contains(nums[i])) {
                continue;
            }
            curList.add(nums[i]);
            backtrack(result, nums, curList);
            curList.remove(curList.size()-1);
        }
    }
}