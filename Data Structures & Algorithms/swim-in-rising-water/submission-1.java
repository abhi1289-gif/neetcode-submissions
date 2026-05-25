class Solution {

    public class Node{
        int val;
        int x;
        int y;

        Node(int val, int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int makeChange(int n, int m, int grid[][]){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> a.val-b.val);
        int dist[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];

        pq.add(new Node(grid[0][0], 0, 0));

        int dir[][] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        while(pq.size() > 0){
            Node curr = pq.poll();
            int x = curr.x;
            int y = curr.y;

            if(x == n-1 && y == m-1) return curr.val;

            if(curr.val > dist[x][y]) continue;

            for(int d[]: dir){
                int i = x + d[0];
                int j = y + d[1];

                if(i<0 || j<0 || i>=n || j>=m) continue;

                int value = Math.max(grid[i][j], curr.val);

                if(value < dist[i][j]){
                    dist[i][j] = value;
                    pq.add(new Node(value, i, j));
                }

            }
             
        }

        return -1;
    }   

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return makeChange(n, m, grid);
    }
}
