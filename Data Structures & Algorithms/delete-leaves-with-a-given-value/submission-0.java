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

    boolean flag;

    public TreeNode rem(TreeNode root, int target){
        if(root == null) return null;
        if(root.left == null && root.right == null && root.val == target){
            flag = true;
            return null;
        }

        root.left = rem(root.left, target);
        root.right = rem(root.right, target);

        return root;
    }

    public int numbr(TreeNode root){
        if(root == null) return 0;

        return 1 + numbr(root.left) + numbr(root.right);
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        int n = numbr(root);
        while(n>0){
            flag = false;
            root = rem(root, target);
            if(!flag) break;
            n--;
        }

        return root;
    }
}