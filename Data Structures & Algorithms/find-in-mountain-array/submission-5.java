/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int i = 0;
        int j = n-1;

        int peak = -1;

        while(i < j){
            int mid = i+(j-i)/2;

            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                i = mid+1;
            }
            else j = mid;
        }

        peak = i;

        if(target == mountainArr.get(peak)) return peak;

        int i1 = 0;
        int j1 = peak-1;
        
        int i2 = peak+1;
        int j2 = n-1;

        int ans1 = -1;
        int ans2 = -1;

        while(i1 <= j1){
            int mid = i1 + (j1-i1)/2;

            if(mountainArr.get(mid) == target){
                ans1 = mid;
                break;
            }
            else if(mountainArr.get(mid) > target){
                j1 = mid-1;
            }
            else i1 = mid+1;
        }

        while(i2 <= j2){
            int mid = i2 + (j2-i2)/2;

            if(mountainArr.get(mid) == target){
                ans2 = mid;
                break;
            }
            else if(mountainArr.get(mid) < target){
                j2 = mid-1;
            }
            else i2 = mid+1;
        }

        if(ans1 != -1) return ans1;

        if(ans2 != -1) return ans2;

        return -1;
    }
}