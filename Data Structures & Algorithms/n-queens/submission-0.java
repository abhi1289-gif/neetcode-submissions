class Solution {

    public boolean isPossible(int x, int y, int n, char board[][]){
        for(int i=0; i<x; i++){
            if(board[i][y] == 'Q') return false;
        }

        for(int j=0; j<y; j++){
            if(board[x][j] == 'Q') return false;
        }

        int i = x-1;
        int j = y-1;

        while(i >= 0 && j >= 0){
            if(board[i--][j--] == 'Q') return false;
        }

        i = x-1;
        j = y+1;

        while(i >= 0 && j < n){
            if(board[i--][j++] == 'Q') return false;
        }
        
        return true;
    }

    public void makeComb(int n, char board[][], int row, List<List<String>> ans){
        if(row == n){
            List<String> part = new ArrayList<>();
            for(int i=0; i<n; i++){
                String temp = "";
                for(int j=0; j<n; j++){
                    temp += board[i][j];
                }
                part.add(temp);
            }
            ans.add(new ArrayList<>(part));
            return;
        }

        for(int col=0; col<n; col++){
            board[row][col] = 'Q';
            if(isPossible(row, col, n, board)){
                makeComb(n, board, row+1, ans);
            }
            board[row][col] = '.';
        }
    }


    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        makeComb(n, board, 0, ans);

        return ans;
    }
}
