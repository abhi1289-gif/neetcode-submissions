class Solution {

    public boolean isPossible(int nums[], int idx){
        if(idx >= nums.length) return false;
        if(idx == nums.length-1) return true;

        if(nums[idx] == 0) return false;

        int val = nums[idx];

        for(int i=val; i>0; i--){
            if(isPossible(nums, idx+i)) return true;
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return isPossible(nums, 0);
    }
}
