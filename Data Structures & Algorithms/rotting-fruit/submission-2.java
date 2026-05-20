class Solution {

    public class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> qu = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int ones = 0;

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i, j));
                }
                else if(grid[i][j] == 1) ones++;
            }
        }

        if(ones == 0) return 0;
        if(qu.size() == 0) return -1;

        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(qu.size() > 0){
            int siz = qu.size();
            boolean flag = false;
            if(ones == 0) break;

            while(siz > 0){
                Pair curr = qu.poll();
                for(int d[]: dir){
                    int x = curr.x + d[0];
                    int y = curr.y + d[1];

                    if(x<0 || y<0 || x>=n || y>=m || grid[x][y]==0 || grid[x][y]==2) continue;

                    grid[x][y] = 2;
                    qu.add(new Pair(x, y));
                    flag = true;
                    ones--;
                }
                siz--;
            }
            if(flag) ans++;
        }
        if(ones != 0) return -1;

        return ans;
    }
}
