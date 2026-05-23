class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxx = 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for(int i=0; i<nums.length; i++){
            int maxtemp = 0;
            for(int j=i-1; j>=0; j--){
                if(nums[j] < nums[i]) maxtemp = Math.max(maxtemp, dp[j]);
            }
            dp[i] = 1 + maxtemp;
        }

        for(int i=0; i<nums.length; i++){
            maxx = Math.max(dp[i], maxx);
        }

        return maxx;
    }
}
