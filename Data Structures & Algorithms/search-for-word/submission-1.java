class Solution {

    public boolean isPossible(char[][] board, int x, int y, int n, int m, boolean visited[][], String word, int idx){
        if(idx >= word.length()) return true;
        if(x<0 || y<0 || x>n || y>m || visited[x][y] || board[x][y] != word.charAt(idx)) return false;

        visited[x][y] = true;

        boolean left = isPossible(board, x+1, y, n, m, visited, word, idx+1);
        boolean up = isPossible(board, x, y-1, n, m, visited, word, idx+1);
        boolean right = isPossible(board, x-1, y, n, m, visited, word, idx+1);
        boolean down = isPossible(board, x, y+1, n, m, visited, word, idx+1);

        visited[x][y] = false;

        return left || right || up || down;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean visited[][] = new boolean[n][m];
                    if(isPossible(board, i, j, n-1, m-1, visited, word, 0)) return true;
                }
            }
        }

        return false;
    }
}
