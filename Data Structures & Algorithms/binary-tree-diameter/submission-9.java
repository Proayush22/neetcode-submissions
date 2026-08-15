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
    int length;

    public int diameterOfBinaryTree(TreeNode root) {
        length = 0;
        dfs(root);
        return length;

    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int right = dfs(root.right);
        int left = dfs(root.left); 
        
        if(length < right + left){
            length = right + left;
        }
        
        return 1 + Math.max(right, left);
    }

}
