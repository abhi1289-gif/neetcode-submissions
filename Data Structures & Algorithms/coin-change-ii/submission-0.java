class Solution {

    public int make(int coins[], int amount, int temp, int dp[][], int idx){
        if(temp == amount) return 1;
        if(temp > amount) return 0;

        if(dp[temp][idx] != -1) return dp[temp][idx];

        int ans = 0;

        for(int i=idx; i<coins.length; i++){
            ans += make(coins, amount, temp+coins[i], dp, i);
        }

        return dp[temp][idx] = ans;
    }

    public int change(int amount, int[] coins) {
        int dp[][] = new int[amount+1][coins.length];
        for(int i=0; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                dp[i][j] = -1;
            }
        }
        return make(coins, amount, 0, dp, 0);
    }
}
