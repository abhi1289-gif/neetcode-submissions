class Solution {

    public int maxx(int[] nums) {
        int n = nums.length;
        if(n<4){
            if(n == 3){
                return Math.max(nums[1], nums[0]+nums[2]);
            }
            if(n == 2){
                return Math.max(nums[1], nums[0]);
            }
            if(n == 1) return nums[0];
        }

        nums[2] = nums[2] + nums[0];

        for(int i=3; i<n; i++){
            nums[i] = nums[i] + Math.max(nums[i-2], nums[i-3]);
        }

        return Math.max(nums[n-1], nums[n-2]);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int num1[] = new int[n-1];
        int num2[] = new int[n-1];

        for(int i=1; i<n; i++){
            num1[i-1] = nums[i];
        }
        for(int i=0; i<n-1; i++){
            num2[i] = nums[i];
        }
        
        return Math.max(maxx(num1), maxx(num2));
    }
}
