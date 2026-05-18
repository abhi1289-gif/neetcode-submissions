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

    public int travel(TreeNode root, int maxx){
        if(root == null) return 0;

        int ans = 0;
        if(maxx <= root.val) ans++;

        maxx = Math.max(maxx, root.val);

        return ans + travel(root.left, maxx) + travel(root.right, maxx);
    }

    public int goodNodes(TreeNode root) {
        return travel(root, root.val); 
    }
}
