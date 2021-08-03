/**
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
    public TreeNode convertBST(TreeNode root) {
        calculate(root, 0);
        return root;
    }
    
    public int calculate(TreeNode root, int sum) {
        if(root == null) {
            return sum;
        }
        root.val += calculate(root.right, sum);
        return calculate(root.left, root.val);
    }
}