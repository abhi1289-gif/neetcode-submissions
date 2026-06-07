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

    public class Pair{
        int with;
        int without;

        Pair(int with, int without){
            this.with = with;
            this.without = without;
        }
    }

    public Pair make(TreeNode root){
        if(root == null) return new Pair(0, 0);

        Pair l = make(root.left);
        Pair r = make(root.right);

        int with = root.val + l.without + r.without;
        int without = Math.max(l.with, l.without) + Math.max(r.with, r.without);

        return new Pair(with, without);
    }

    public int rob(TreeNode root) {
        Pair ans = make(root);

        return Math.max(ans.with, ans.without);
    }
}