class Solution {

    int dp[];

    public int ways(String s, int i, int n){
        if(i >= n) return 1;

        if(s.charAt(i)=='0') return 0;

        if(dp[i] != -1) return dp[i];

        int ans = 0;

        if(s.charAt(i) != '0'){
            ans += ways(s, i+1, n);
        }

        if(i+1 < n && s.charAt(i) != '0'){
            int num = (s.charAt(i) - '0')*10 + (s.charAt(i+1) - '0');
            if(num <= 26){
                ans += ways(s, i+2, n);
            }
        }

        return dp[i] = ans;
    }

    public int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0') return 0;
        if(n<2) return 1;
        dp = new int[n];
        for(int i=0; i<n; i++) dp[i] = -1;
        int result = ways(s, 0, n);
        return result;
    }

}
