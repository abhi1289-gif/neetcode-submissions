class Solution {

    Boolean dp[][];

    public boolean isValid(String s, int idx, int open){
        if(open < 0) return false;

        if(idx == s.length()) return open == 0;

        if(dp[idx][open] != null) return dp[idx][open];


        if(s.charAt(idx) == '('){
            return dp[idx][open] = isValid(s, idx+1, open+1);
        }
        if(s.charAt(idx) == ')'){
            return dp[idx][open] = isValid(s, idx+1, open-1);
        }

        return dp[idx][open] = isValid(s, idx+1, open+1) || isValid(s, idx+1, open) || isValid(s, idx+1, open-1);
    }

    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()+1][s.length()+1];
        return isValid(s, 0, 0);
    }
}