class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int n = nums.length;
        int j = n-1;
        int sum = nums[i] + nums[j];

        while(i<j){
            if(sum == target) return new int[]{i+1, j+1};
            if(sum<target){
                sum -= nums[i];
                i++;
                sum += nums[i];
            }
            else{
                sum -= nums[j];
                j--;
                sum += nums[j];
            }
        }

        return new int[]{-1, -1};
    }
}
