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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        qu.add(root);

        while(qu.size() > 0){
            int siz = qu.size();
            List<Integer> temp = new ArrayList<>();
            while(siz>0){
                TreeNode curr = qu.peek();
                qu.poll();

                temp.add(curr.val);
                if(curr.left != null) qu.add(curr.left);
                if(curr.right != null) qu.add(curr.right);
                siz--;
            }
            ans.add(new ArrayList(temp));
        }

        return ans;
    }
}
