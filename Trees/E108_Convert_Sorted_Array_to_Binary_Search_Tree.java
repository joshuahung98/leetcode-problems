/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 * Runtime: O(n) - T(n) = 2T(n/2) + O(1)
 * Space Complexity: O(log n) at most log n recursion stack
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums.length-1);
    }
    
    public TreeNode constructTree(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2; 
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructTree(nums, start, mid - 1);
        node.right = constructTree(nums, mid + 1, end);
        return node;
    }
}