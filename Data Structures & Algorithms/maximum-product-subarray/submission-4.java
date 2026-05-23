class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pro = 1;
        int maxx = Integer.MIN_VALUE;
        int pro1 = 1;
        int pro2 = 1;

        for(int i=0; i<n; i++){
            maxx = Math.max(maxx, nums[i]);
        }

        for(int i=0; i<n; i++){
            pro1 *= nums[i];
            maxx = Math.max(maxx, pro1);
            if(pro1 == 0) pro1 = 1;
        }

        for(int i=n-1; i>=0; i--){
            pro2 *= nums[i];
            maxx = Math.max(maxx, pro2);
            if(pro2 == 0) pro2 = 1;
        }

        pro = maxx;

        return pro;
    }
}
