class Solution {

    int dp[];

    public int isPossible(int nums[], int idx){
        if(idx >= nums.length) return 1000000;
        if(idx == nums.length-1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int val = nums[idx];
        int ans = 10000000;

        for(int i=val; i>0; i--){
            ans = Math.min(ans, 1 + isPossible(nums, idx+i));
        }

        return dp[idx] = ans;
    }

    public int jump(int[] nums) {
        dp = new int[nums.length];
        for(int i=0; i<nums.length; i++) dp[i] = -1;

        return isPossible(nums, 0);
    }
}
