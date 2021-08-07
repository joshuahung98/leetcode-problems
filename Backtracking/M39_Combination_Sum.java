/*
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the 
 * chosen numbers sum to target. You may return the combinations in any order. The same number may be chosen from candidates an unlimited number 
 * of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different. It is guaranteed that the number 
 * of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Runtime: O(2^n) - choose to take or not to take each time, 2^n possibilities for each element
 * Space complexity: O(n)
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int startIndex, List<List<Integer>> result, List<Integer> curList) {
        if(target < 0) {
            return;
        } else if(target == 0) {
            result.add(new ArrayList<>(curList));
        } else {
            for(int i = startIndex; i < candidates.length; i++) {
                curList.add(candidates[i]);
                backtrack(candidates, target-candidates[i], i, result, curList);
                curList.remove(curList.size()-1);
            }
        }
    }
}