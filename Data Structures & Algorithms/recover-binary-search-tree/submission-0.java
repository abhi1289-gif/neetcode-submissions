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

    TreeNode prev = null;
    TreeNode fir = null;
    TreeNode sec = null;

    public void inorderl(TreeNode root){
        if(root==null) return;

        inorderl(root.left);

        if(prev != null && prev.val > root.val){
            if(fir == null){
                fir = prev;
            }

            sec = root;
        }

        prev = root;

        inorderl(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorderl(root);

        int temp = fir.val;
        fir.val = sec.val;
        sec.val = temp;

    }
}