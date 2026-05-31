class Solution {
    public boolean mergeTriplets(int[][] nums, int[] target) {
        int n = nums.length;

        boolean f1 = false, f2 = false, f3 = false;

        if(n == 1){
            if(nums[0][0] == target[0] && nums[0][1] == target[1] && nums[0][2] == target[2]) return true;
        }

        for(int i=0; i<n; i++){
            if(nums[i][0] > target[0] || nums[i][1] > target[1] || nums[i][2] > target[2])continue;

            if(nums[i][0] == target[0]) f1 = true;
            if(nums[i][1] == target[1]) f2 = true;
            if(nums[i][2] == target[2]) f3 = true;

            if(f1 && f2 && f3) return true;
        }

        return false;
    }
}
