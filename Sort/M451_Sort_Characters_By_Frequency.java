/*
 * Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
 *
 * Can also be done with a priority queue, which takes O(nlogm) time. This is a bucket sort solution.
 *
 * Runtime: O(n)
 * Space Complexity: O(n + k)- but bucket sort uses less space. k is for the # of buckets 
 */
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        List<Character>[] bucketList = new ArrayList[s.length()+1];
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if(bucketList[frequency] == null) {
                bucketList[frequency] = new ArrayList<>();
            }
            bucketList[frequency].add(entry.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = s.length(); i >= 0; i--) {
            if(bucketList[i] != null) {
                for(char c : bucketList[i]) {
                    for(int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}