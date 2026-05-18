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

        int l = addPositives(root.left);
        int r = addPositives(root.right);

        root.val += l + r;

        if(root.val - Math.min(l, r) > 0) return root.val - Math.min(l, r);
        return 0;
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
