class Solution {

    public class Pair{
        int node;
        int weight;

        Pair(int node, int weight){
            this.node = node;
            this.weight  = weight;
        }
    }

    List<List<Pair>> graph;

    public int dijkstra(int n){
        boolean visited[] = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->a.weight-b.weight);
        int dist[] = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;

        dist[0] = 0;
        pq.add(new Pair(0, 0));

        int ans = Integer.MIN_VALUE;

        while(pq.size() > 0){
            Pair curr = pq.poll();

            ans = Math.max(ans, dist[curr.node]);
            if(curr.node == n-1) break;

            if(visited[curr.node]) continue;
            visited[curr.node] = true;

            for(Pair nebr: graph.get(curr.node)){
                if(!visited[nebr.node] && dist[nebr.node] > Math.max(dist[curr.node], nebr.weight)){
                    dist[nebr.node] = Math.max(dist[curr.node], nebr.weight);
                    pq.add(new Pair(nebr.node, dist[nebr.node]));
                }
            }
        }

        return ans;
    }

    public int minimumEffortPath(int[][] nums) {
        graph = new ArrayList<>();

        int n = nums.length;
        int m = nums[0].length;

        for(int i=0; i<n*m; i++) graph.add(new ArrayList<>());

        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int u = i * m + j;

                for(int k=0; k<4; k++){
                    
                    int x = i+dir[k][0];
                    int y = j+dir[k][1];

                    if(x<0 || y<0 || x>=n || y>=m) continue;

                    int v = x * m + y;

                    int wt = Math.abs(nums[i][j]-nums[x][y]);

                    graph.get(u).add(new Pair(v, wt));
                }
            }
        }

        int ans = dijkstra(n*m);

        return ans;
    }
}