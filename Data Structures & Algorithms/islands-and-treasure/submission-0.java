class Solution {

    int INF = Integer.MAX_VALUE;

    public class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> qu = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 0){
                    qu.add(new Pair(i, j));
                }
            }
        }

        int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(qu.size() > 0){
            Pair curr = qu.poll();

            for(int d[]: dir){
                int x = curr.x + d[0];
                int y = curr.y + d[1];

                if(x<0 || y<0 || x>=n || y>=m || grid[x][y]==-1 || grid[x][y]!=INF) continue;

                grid[x][y] = grid[curr.x][curr.y] + 1;
                qu.add(new Pair(x, y));
            }
        }
    }
}
