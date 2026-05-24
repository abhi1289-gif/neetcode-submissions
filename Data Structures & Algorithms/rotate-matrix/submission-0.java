class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int nums[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                nums[i][j] = matrix[i][j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = nums[n-1-j][i];
            }
        }

    }
}