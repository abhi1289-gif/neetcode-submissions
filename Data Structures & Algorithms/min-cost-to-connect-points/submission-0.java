class Solution {

    public class Pair{
        int dest;
        int wt;
        Pair(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    List<List<Pair>> graph = new ArrayList<>();

    public int traverse(int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.wt-b.wt);
        boolean visited[] = new boolean[n];
        pq.add(new Pair(0, 0));
        int ans = 0;
        int nodes = 0;

        while(pq.size() > 0){
            if(n == nodes) break;

            Pair curr = pq.poll();
            if(visited[curr.dest]) continue;
            visited[curr.dest] = true;
            ans += curr.wt;
            nodes++;

            for(Pair nebr: graph.get(curr.dest)){
                if(visited[nebr.dest]) continue;
                pq.add(new Pair(nebr.dest, nebr.wt));
            }
        }

        return ans;
    }


    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.get(i).add(new Pair(j, dist));
                graph.get(j).add(new Pair(i, dist));
            }
        }

        return traverse(n);
    }
}
