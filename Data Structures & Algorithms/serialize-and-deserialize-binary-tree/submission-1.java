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

public class Codec {

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     Queue<TreeNode> qu = new LinkedList<>();
    //     List<List<Integer>> ans = new ArrayList<>();
    //     if(root == null) return ans;
    //     qu.add(root);

    //     while(qu.size() > 0){
    //         int siz = qu.size();
    //         List<Integer> temp = new ArrayList<>();
    //         while(siz>0){
    //             TreeNode curr = qu.peek();
    //             qu.poll();

    //             if(curr == null){
    //                 temp.add(11111);
    //                 siz--;
    //                 continue;
    //             }

    //             temp.add(curr.val);

    //             qu.add(curr.left);
    //             qu.add(curr.right);

    //             siz--;
    //         }
    //         ans.add(new ArrayList(temp));
    //     }

    //     return ans;
    // }

    // public String listToString(List<List<Integer>> list){
    //     if(list.size() == 0) return "";
    //     String ans = "";
    //     for(int i=0; i<list.size(); i++){
    //         String s = "";
    //         for(int j=0; j<list.get(i).size(); j++){
    //             if(list.get(i).get(j) != 11111){
    //                 String temp = Integer.toString(list.get(i).get(j));
    //                 s += temp;
    //             }
    //             else s += 'N';

    //             if(j != list.get(i).size()-1) s += ' ';
    //         }
    //         ans += s;
    //         if(i != list.size()-1) ans += '_';
    //     }

    //     return ans;
    // }

    // public List<String> listToStringList(String s){
    //     int i = 0;
    //     List<String> ans = new ArrayList<>();
    //     while(i < s.length()){
    //         StringBuilder temp = new StringBuilder();
    //         while(i < s.length() && s.charAt(i) != '_'){
    //             temp.append(s.charAt(i));
    //             i++;
    //         }
    //         i++;
    //         ans.add(temp.toString());
    //     }

    //     return ans;
    // }

    // public List<List<Integer>> listOfStringToListListInt(List<String> nums){
    //     List<List<Integer>> ans = new ArrayList<>();

    //     for(int j=0; j<nums.size(); j++){
    //         String s = nums.get(j);
    //         List<Integer> num = new ArrayList<>();
    //         int i = 0;
    //         while(i < s.length()){
    //             StringBuilder temp = new StringBuilder();
    //             while(i < s.length() && s.charAt(i) != ' '){
    //                 temp.append(s.charAt(i));
    //                 i++;
    //             }

    //             if(temp.toString().equals("N")){
    //                 num.add(11111);
    //                 i++;
    //                 continue;
    //             }

    //             num.add(Integer.parseInt(temp.toString()));
    //             i++;
    //         }
    //         ans.add(num);
    //     }

    //     return ans;
    // }

    // public TreeNode listToTree(List<List<Integer>> nums){
    //     if(nums.size() == 0) return null;
    //     if(nums.get(0).get(0)==11111)return null;

    //     TreeNode ans = new TreeNode(nums.get(0).get(0));

    //     Queue<TreeNode> qu = new LinkedList<>();

    //     qu.add(ans);

    //     int i = 1;
    //     while(i < nums.size()){
            
    //         int siz = qu.size();

    //         int j = 0;
    //         int n = nums.get(i).size();

    //         while(siz > 0){
    //             TreeNode curr = qu.poll();

    //             if(curr == null){
    //                 siz--;
    //                 continue;
    //             }
    //             if(j<n){
    //                     if(nums.get(i).get(j) == 11111){
    //                     curr.left = null;
    //                 }
    //                 else{
    //                     TreeNode left = new TreeNode(nums.get(i).get(j));
    //                     qu.add(left);
    //                     curr.left = left;
    //                 }
    //                 j++;
    //             }

    //             if(j < n){
    //                 if(nums.get(i).get(j) == 11111){
    //                     curr.right = null;
    //                 }
    //                 else{
    //                     TreeNode right = new TreeNode(nums.get(i).get(j));
    //                     qu.add(right);
    //                     curr.right = right;
    //                 }
    //                 j++;
    //             }

    //             siz--;
    //         }
    //         i++;
    //     }
    //     return ans;
    // }

    // // Encodes a tree to a single string.
    // public String serialize(TreeNode root) {
    //     List<List<Integer>> temp = levelOrder(root);
    //     String ans = listToString(temp);

    //     return ans;
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     List<String> temp = listToStringList(data);
    //     List<List<Integer>> trial = listOfStringToListListInt(temp);
    //     TreeNode ans = listToTree(trial);

    //     return ans;
    // }

    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);

        while(qu.size() > 0){
            TreeNode curr = qu.poll();

            if(curr == null){
                ans.append("N ");
                continue;
            }

            ans.append(curr.val);
            ans.append(" ");

            qu.add(curr.left);
            qu.add(curr.right);

        }

        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;

        String arr[] = data.split(" ");

        TreeNode ans = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(ans);

        int i = 1;

        while(qu.size() > 0){
            TreeNode curr = qu.poll();

            if(!arr[i].equals("N")){
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                qu.add(curr.left);
            }

            i++;

            if(!arr[i].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                qu.add(curr.right);
            }
            i++;
        }
        return ans;
    }
}
