class Solution {

    Boolean dp[];

    public boolean isPossible(int nums[], int idx){
        if(idx >= nums.length) return false;
        if(idx == nums.length-1) return true;

        if(nums[idx] == 0) return dp[idx] = false;

        if(dp[idx] != null) return dp[idx];

        int val = nums[idx];

        for(int i=val; i>0; i--){
            dp[idx] = (isPossible(nums, idx+i));
            if(dp[idx]) return true;
        }

        return dp[idx] = false;
    }

    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length+1];
        return isPossible(nums, 0);
    }
}
