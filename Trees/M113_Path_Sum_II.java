/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 * A leaf is a node with no children.
 *
 * Runtime: O(n) - visits each node once.
 * Space complexity: O(n): possibly n recursive calls
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper(root, targetSum, result, new ArrayList<>());
        return result;
    }
    
    public void helper(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> curList) {
        if(root == null) {
            return;
        }
        
        curList.add(root.val);
        if(root.left == null && root.right == null) {
            if(root.val == targetSum) {
                result.add(new ArrayList<>(curList));
            }
            return;
        }
        
        if(root.left != null) {
            helper(root.left, targetSum - root.val, result, curList);
            curList.remove(curList.size()-1);
        }
        
        if(root.right != null) {
            helper(root.right, targetSum - root.val, result, curList);
            curList.remove(curList.size()-1);
        }
    }
}