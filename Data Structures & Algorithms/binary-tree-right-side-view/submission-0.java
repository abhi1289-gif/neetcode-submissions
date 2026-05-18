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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        qu.add(root);

        while(qu.size() > 0){
            int siz = qu.size();
            while(siz>0){
                TreeNode curr = qu.peek();
                qu.poll();

                if(curr.left != null) qu.add(curr.left);
                if(curr.right != null) qu.add(curr.right);
                siz--;
                if(siz == 0) ans.add(curr.val);
            }
        }

        return ans;
    }
}
