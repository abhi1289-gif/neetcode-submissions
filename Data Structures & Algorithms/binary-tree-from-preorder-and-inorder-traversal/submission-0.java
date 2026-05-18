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

    public TreeNode built(int pre[], int pres, int pree, int in[], int ins, int ine){
        if(pres>pree || ins>ine) return null;

        TreeNode root = new TreeNode(pre[pres]);

        int i = ins;

        while(in[i] != pre[pres]) i++;

        int idx = i-ins;

        root.left = built(pre, pres+1, pres+idx, in, ins, i-1);
        root.right = built(pre, pres+idx+1, pree, in, i+1, ine);

        return root;
    }

    public TreeNode buildTree(int[] pre, int[] in) {
        TreeNode ans = built(pre, 0, pre.length-1, in, 0, in.length-1);
        return ans;
    }
}
