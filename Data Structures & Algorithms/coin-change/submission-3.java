class Solution {

    int INF = (int)1e9;

    public int findWays(int[] coins, int amount, int sum, int dp[]){
        if(sum == amount) return 0;
        if(sum > amount) return INF;

        if(dp[sum] != -1) return dp[sum];

        int ans = INF;

        for(int i=0; i<coins.length; i++){
            if(sum > amount - coins[i]) continue;
            int res = findWays(coins, amount, sum + coins[i], dp);
            if(res != INF){
                ans = Math.min(ans, 1+res);
            }
        }

        return dp[sum] = ans;
    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for(int i=0; i<=amount; i++) dp[i] = -1;
        int sum = 0;
        int result = findWays(coins, amount, sum, dp);
        return (result==INF)? -1: result;
    }
}
