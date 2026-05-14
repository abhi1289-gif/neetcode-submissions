class Solution {

    public boolean isPossible(char[][] board, int x, int y){
        for(int i=0; i<9; i++){
            if(i == x) continue;
            if(board[i][y] == board[x][y]) return false;
        }
        for(int i=0; i<9; i++){
            if(i == y) continue;
            if(board[x][i] == board[x][y]) return false;
        }

        int a = (x/3)*3;
        int b = (y/3)*3;

        for(int i=a; i<a+3; i++){
            for(int j=b; j<b+3; j++){
                if(i == x && y == j) continue;
                if(board[i][j] == board[x][y]) return false; 
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                else{
                    if(isPossible(board, i, j)) continue;
                    else return false;
                }
                
            }
        }
        return true;
    }
}