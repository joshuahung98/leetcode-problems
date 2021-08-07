/*
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * 
 * Runtime: O(n) - bubble sort takes O(n) time
 * Space complexity: O(n) 
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        List<Integer>[] bucketList = new ArrayList[nums.length + 1];
        for(int cur : map.keySet()) {
            int frequency = map.get(cur);
            if(bucketList[frequency] == null) {
                bucketList[frequency] = new ArrayList<>();
            }
            bucketList[frequency].add(cur);
        }
        
        int[] result = new int[k];
        int arrIndex = 0;
        for(int i = nums.length; i >= 0; i--) {
            if(bucketList[i] != null) {
                for(int num : bucketList[i]) {
                    result[arrIndex] = num;
                    arrIndex++;
                    if(arrIndex == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}