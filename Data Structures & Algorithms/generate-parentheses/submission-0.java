class Solution {

    public void generate(int n, int l, int r, String s, List<String> ans){
        if(r == n){
            ans.add(s);
            return;
        }

        if(n>l) generate(n, l+1, r, s+'(', ans);

        if(l>r) generate(n, l, r+1, s+')', ans);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        generate(n, 0, 0, s, ans);
        return ans;
    }
}
