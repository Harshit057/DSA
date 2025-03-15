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
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }
    
    private int[] robHelper(TreeNode node) {
        if (node == null) return new int[]{0, 0}; // Base case
        
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        
        // If robbing the current house, we can't rob children
        int rob = node.val + left[1] + right[1];
        
        // If skipping the current house, we take max of both choices from children
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{rob, notRob}; // Return both cases
    }
}
