class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int pre[] = new int[n];
        int suff[] = new int[n];

        pre[0] = heights[0];
        suff[n-1] = heights[n-1];

        for(int i=1; i<n; i++){
            pre[i] = Math.max(pre[i-1], heights[i]);
        }

        for(int j=n-2; j>=0; j--){
            suff[j] = Math.max(suff[j+1],heights[j]); 
        }
        int i = 0;
        int j = n-1;
        int maxx = 0;

        while(i<j){
            if(pre[i] < suff[j]){
                maxx = Math.max(maxx, (j-i)*pre[i]);
                i++;
            }
            else{
                maxx = Math.max(maxx, (j-i)*suff[j]);
                j--;
            }
        }

        return maxx;
    }
}