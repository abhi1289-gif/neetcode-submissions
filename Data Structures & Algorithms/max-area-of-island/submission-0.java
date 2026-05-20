class Solution {

    public int dfs(int x, int y, int n, int m, boolean visited[][], int grid[][]){
        if(x<0 || y<0 || x>n || y>m || visited[x][y] || grid[x][y] == 0) return 0;

        visited[x][y] = true;

        int a = dfs(x+1, y, n, m, visited, grid);
        int b = dfs(x, y-1, n, m, visited, grid);
        int c = dfs(x-1, y, n, m, visited, grid);
        int d = dfs(x, y+1, n, m, visited, grid);

        return 1 + a + b + c + d;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    int temp = dfs(i, j, n-1, m-1, visited, grid);
                    ans = Math.max(ans, temp);
                }
            }
        }

        return ans;
    }
}
