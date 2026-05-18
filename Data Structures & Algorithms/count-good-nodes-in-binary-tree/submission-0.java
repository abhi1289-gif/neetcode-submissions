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

    int ans;

    public void travel(TreeNode root, int maxx){
        if(root == null) return;

        if(maxx <= root.val) ans++;

        maxx = Math.max(maxx, root.val);

        travel(root.left, maxx);
        travel(root.right, maxx);
    }

    public int goodNodes(TreeNode root) {
        ans = 0;
        travel(root, root.val);
        return ans;
    }
}
