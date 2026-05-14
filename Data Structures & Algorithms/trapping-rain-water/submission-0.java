class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int brr[] = new int[n];
        int maxx = nums[0];

        arr[0] = -1;
        for(int i=1; i<n; i++){
            arr[i] = maxx;
            if(nums[i] > maxx){
                maxx = nums[i];
            }
        }

        brr[n-1] = -1;
        maxx = nums[n-1];

        for(int i=n-2; i>=0; i--){
            brr[i] = maxx;
            if(nums[i]>maxx){
                maxx = nums[i];
            }; 
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            int temp = Math.min(arr[i], brr[i])-nums[i];
            if(temp > 0) ans += temp;
        }

        return ans;
    }
}
