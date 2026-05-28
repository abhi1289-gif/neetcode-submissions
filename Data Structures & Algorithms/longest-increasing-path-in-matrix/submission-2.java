class Solution {

    int dp[][];

    public int make(int grid[][], int x, int y, int n, int m, int ans, int prevVal){
        if(x<0 || y<0 || x>=n || y>=m) return 0;

        if(grid[x][y] <= prevVal){
            return 0;
        }

        if(dp[x][y] != -1) return dp[x][y];

        int l = 1 + make(grid, x+1, y, n, m, ans+1, grid[x][y]);
        int r = 1 + make(grid, x-1, y, n, m, ans+1, grid[x][y]);
        int u = 1 + make(grid, x, y+1, n, m, ans+1, grid[x][y]);
        int d = 1 + make(grid, x, y-1, n, m, ans+1, grid[x][y]);

        return dp[x][y] = Math.max(l, Math.max(r, Math.max(u, d)));
    }

    public int longestIncreasingPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dp[i][j] = -1;
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans, make(grid, i, j, n, m, 1, -1));
            }
        }
        return ans;
    }
}
