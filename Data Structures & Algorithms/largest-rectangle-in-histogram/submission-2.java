class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = heights[0];
        int n = heights.length;
        for(int i=0; i<n; i++){
            int l = i-1, r = i+1;
            int sum = heights[i];
            while(l>=0 && heights[l--]>=heights[i]) sum += heights[i];
            while(r<n && heights[r++]>=heights[i]) sum += heights[i];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
