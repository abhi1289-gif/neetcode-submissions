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

    public boolean isPossible(TreeNode root, int minn, int maxx){
        if(root == null) return true;

        if(root.val <= minn || root.val >= maxx) return false;

        return isPossible(root.left, minn, root.val) && isPossible(root.right, root.val, maxx); 
    }

    public boolean isValidBST(TreeNode root) {
        return isPossible(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
