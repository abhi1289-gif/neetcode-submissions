class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = n*m-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            int row = mid/m;
            int col = mid%m;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return false;
    }
}
