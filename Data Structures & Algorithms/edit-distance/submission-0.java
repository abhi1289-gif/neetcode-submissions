class Solution {

    public int change(String s, String t, int i, int j, int dp[][]){
        if(i<0) return j+1;
        else if(j<0) return i+1;

        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = change(s, t, i-1, j-1, dp);

        if(dp[i][j] != -1) return dp[i][j];

        int insert = 1 + change(s, t, i, j-1, dp);
        int delete = 1 + change(s, t, i-1, j, dp);
        int replace = 1 + change(s, t, i-1, j-1, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        return change(word1, word2, n-1, m-1, dp);
    }
}
