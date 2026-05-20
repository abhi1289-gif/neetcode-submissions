class Solution {

    public void dfs(int x, int y, int n, int m, char board[][], boolean visited[][]){
        if(x<0 || y<0 || x>n || y>m || visited[x][y] || board[x][y] == 'X') return;

        visited[x][y] = true;

        dfs(x+1, y, n, m, board, visited);
        dfs(x, y-1, n, m, board, visited);
        dfs(x-1, y, n, m, board, visited);
        dfs(x, y+1, n, m, board, visited);
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean visited[][] = new boolean[n][m];

        for(int i=0; i<n; i++){
            if(board[i][0]=='O' && !visited[i][0]) dfs(i, 0, n-1, m-1, board, visited);
            if(board[i][m-1]=='O' && !visited[i][m-1]) dfs(i, m-1, n-1, m-1, board, visited);
        }

        for(int j=0; j<m; j++){
            if(board[0][j]=='O' && !visited[0][j]) dfs(0, j, n-1, m-1, board, visited);
            if(board[n-1][j]=='O' && !visited[n-1][j]) dfs(n-1, j, n-1, m-1, board, visited);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]) board[i][j] = 'X';
            }
        }
    }
}
