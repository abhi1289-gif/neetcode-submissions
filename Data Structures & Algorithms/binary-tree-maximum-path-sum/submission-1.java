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

    public int addPositives(TreeNode root){
        if(root == null) return 0;

        int l = Math.max(0, addPositives(root.left));
        int r = Math.max(0, addPositives(root.right));

        root.val += l + r;

        return root.val - Math.min(l, r);
    }

    int maxx = Integer.MIN_VALUE;

    public void travel(TreeNode root){
        if(root == null) return;

        maxx = Math.max(maxx, root.val);

        travel(root.left);
        travel(root.right);
    }

    public int maxPathSum(TreeNode root) {
        addPositives(root);
        travel(root);
        return maxx;
    }
}
