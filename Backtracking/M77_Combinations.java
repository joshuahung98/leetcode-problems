/*
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * You may return the answer in any order.
 * 
 * Why n-k+1? Makes it way more efficient. 
 * For anyone stumped by why this change is necessary, it's because you should not continue exploring (recursing) when 
 * you know that there won't be enough numbers left until n to fill the needed k slots. If n = 10, k = 5, and you're in the 
 * outermost level of recursion, you choose only i = 1...6 , because if you pick i=7 and go into backTracking() you only have 
 * 8,9,10 to pick from, so at most you will get [7,8,9,10]... but we need 5 elements!
 * 
 * Runtime: O(n choose K)
 * Explanation: https://stackoverflow.com/questions/24643367/whats-time-complexity-of-this-algorithm-for-finding-all-combinations
 * Space complexity: O(k^2)
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }
    
    public void backtrack(int n, int k, List<List<Integer>> result, List<Integer> curList, int start) {
        if(k == 0) {
            result.add(new ArrayList<>(curList));
            return;
        }
        for(int i = start; i <= n-k + 1; i++) {
            curList.add(i);
            backtrack(n, k-1, result, curList, ++start);
            curList.remove(curList.size()-1);
        }
    }
    
}