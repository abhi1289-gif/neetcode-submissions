class Solution {

    public void isPossibleleft(int x, int y, int hite[][], int n, int m, char l[][]){
        if(x<0 || y<0 || x>=n || y>=m || l[x][y]=='L') return;

        l[x][y] = 'L';

        if(x-1 >=0 && hite[x-1][y]>=hite[x][y]) isPossibleleft(x-1, y, hite, n, m, l);
        if(y-1 >=0 && hite[x][y-1]>=hite[x][y]) isPossibleleft(x, y-1, hite, n, m, l);
        if(x+1 < n && hite[x+1][y]>=hite[x][y]) isPossibleleft(x+1, y, hite, n, m, l);  
        if(y+1 < m && hite[x][y+1]>=hite[x][y]) isPossibleleft(x, y+1, hite, n, m, l);

    }

    public void isPossibleright(int x, int y, int hite[][], int n, int m, char r[][]){
        if(x<0 || y<0 || x>=n || y>=m || r[x][y]=='R') return;

        r[x][y] = 'R';

        if(x-1 >=0 && hite[x-1][y]>=hite[x][y]) isPossibleright(x-1, y, hite, n, m, r);
        if(y-1 >=0 && hite[x][y-1]>=hite[x][y]) isPossibleright(x, y-1, hite, n, m, r);
        if(x+1 < n && hite[x+1][y]>=hite[x][y]) isPossibleright(x+1, y, hite, n, m, r);  
        if(y+1 < m && hite[x][y+1]>=hite[x][y]) isPossibleright(x, y+1, hite, n, m, r);
    
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        char l[][] = new char[n][m];
        char r[][] = new char[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                l[i][j] = '#';
                r[i][j] = '#';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i==0 || j==0) && l[i][j]!='L'){
                    isPossibleleft(i, j, heights, n, m, l);
                }

                if((i==n-1 || j==m-1) && r[i][j]!='R'){
                    isPossibleright(i, j, heights, n, m, r);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(l[i][j] =='L' && r[i][j] =='R'){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}
