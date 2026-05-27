class Solution {

    Boolean dp[][];

    public boolean make(String s, String p, int i, int j){
        
        if(j == p.length()){
            return dp[i][j] = (i == s.length());
        }

        if(dp[i][j] != null) return dp[i][j];

        boolean first = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean ans;

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            ans = make(s, p, i, j+2) || (first && make(s, p, i+1, j));
        }
        else{
            ans = first && make(s, p, i+1, j+1);
        }

        return dp[i][j] = ans;
    }

    public boolean isMatch(String s, String p){
        dp = new Boolean[s.length()+1][p.length()+1];
        return make(s, p, 0, 0);
    }
}
