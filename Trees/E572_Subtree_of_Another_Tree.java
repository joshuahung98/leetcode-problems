/**
 * 
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 * 
 * Runtime: O(m * n) - this is for if it goes through both trees, worst case
 * Space: O(n) - n calls on the stack
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
 *  
 *   }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return root != null && (helper(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
    
    public boolean helper(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root != null && subRoot != null && root.val == subRoot.val) {
            return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
        }
        return false;
    }
}