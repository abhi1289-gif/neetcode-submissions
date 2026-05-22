class Solution {
    public int uniquePaths(int n, int m) {

        if(n == 1 || m == 1) return 1;

        int nums[][] = new int[n][m];
        for(int i=0; i<n; i++){
            nums[i][0] = 1;
        }
        for(int i=0; i<m; i++){
            nums[0][i] = 1;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                nums[i][j] = nums[i-1][j] + nums[i][j-1];
            }
        }
        
        return nums[n-1][m-1];
    }
}
