class Solution {


    public boolean isPossible(int nums[], int target, int sum, boolean visited[]){
        if(sum == target) return true;

        if(sum > target) return false;

        for(int i=0; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            if(isPossible(nums, target, sum+nums[i], visited)) return true;
            visited[i] = false;
        }

        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        if(sum%2 != 0) return false;

        Arrays.sort(nums);

        int reqSum = sum/2;

        boolean visited[] = new boolean[n];

        return (isPossible(nums, reqSum, 0, visited));

    }
}
