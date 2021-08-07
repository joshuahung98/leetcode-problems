/**
 * Given the root of a binary tree, return the length of the diameter of the tree. The diameter of a binary tree is the length of the longest 
 * path between any two nodes in a tree. This path may or may not pass through the root. The length of a path between two nodes is represented 
 * by the number of edges between them.
 * 
 * Runtime: O(n)- visits each node once
 * Space complexity: O(n) - n recursive calls on the stack
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getLengths(root);
        return max;
    }
    
    public int getLengths(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getLengths(root.left);
        int right = getLengths(root.right);
        
        max = Math.max(max, left + right);        
        return 1 + Math.max(left, right);
    }

}