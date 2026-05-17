class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);

        boolean even = true;
        int sum = len1 + len2;

        if(sum%2 != 0) even = false;

        int lenLeft = (sum+1)/2;

        int low = 0;
        int high = len1;

        while(low <= high){
            int mid1 = low + (high-low)/2;
            int mid2 = lenLeft - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1 - 1 >= 0) l1 = nums1[mid1-1];
            if(mid2 - 1 >= 0) l2 = nums2[mid2-1];
            if(mid1 < len1) r1 = nums1[mid1];
            if(mid2 < len2) r2 = nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if(even){
                    return (double)((Math.max(l1, l2) + Math.min(r1, r2))/2.0);
                }
                return Math.max(l1, l2);
            }
            else if(l1 > r2) high = mid1-1;
            else low = mid1+1;   
        }

        return -1;
    }
}
