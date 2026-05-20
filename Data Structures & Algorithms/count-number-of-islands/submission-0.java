class Solution {

    public void dfs(int x, int y, int n, int m, boolean visited[][], char grid[][]){
        if(x<0 || y<0 || x>n || y>m || visited[x][y] || grid[x][y] == '0') return;

        visited[x][y] = true;

        dfs(x+1, y, n, m, visited, grid);
        dfs(x, y-1, n, m, visited, grid);
        dfs(x-1, y, n, m, visited, grid);
        dfs(x, y+1, n, m, visited, grid);
    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] != '0' && !visited[i][j]){
                    ans++;
                    dfs(i, j, n-1, m-1, visited, grid);
                }
            }
        }

        return ans;
    }
}
