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
    int t;

    public void travel(TreeNode root){
        if(root == null) return;

        travel(root.left);
        t--;
        if(t == 0){
            ans = root.val;
            return;
        }
        travel(root.right);

    }

    public int kthSmallest(TreeNode root, int k) {
        t = k;
        travel(root);
        return ans;
    }
}
