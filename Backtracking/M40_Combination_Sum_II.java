/*
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate 
 * numbers sum to target. Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * 
 * Runtime: O(2 ^ n), since we have 2 ^ n possibilities about the element, for every element we can
 * choose or not choose, thus it is 2 ^ n
 * Space complexity: O(n)
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    public void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> curList, int startIndex) {
        if(target == 0) {
            result.add(new ArrayList<>(curList));
        } else if(target < 0) {
            return;
        } else {
            for(int i = startIndex; i < candidates.length; i++) {
                if(i > startIndex && candidates[i] == candidates[i-1]) {
                    continue;
                }
                curList.add(candidates[i]);
                backtrack(candidates, target-candidates[i], result, curList, i+1);
                curList.remove(curList.size()-1);
            }
        }
    }
}