class Solution {

    int ans = 0;

    public void make(int idx, int sum, int target, int nums[]){
        if(idx == nums.length){
            if(target == sum){
                ans++;
            }
            return;
        }

        make(idx+1, sum-nums[idx], target, nums);
        make(idx+1, sum+nums[idx], target, nums);
    }

    public int findTargetSumWays(int[] nums, int target) {
        make(0, 0, target, nums);
        return ans;
    }
}