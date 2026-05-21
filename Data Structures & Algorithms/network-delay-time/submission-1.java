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

    public int traverse(int src, int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.wt-b.wt);
        boolean visited[] = new boolean[n];
        pq.add(new Pair(src, 0));
        int ans = 0;
        int nodes = 0;

        while(pq.size() > 0){
            Pair curr = pq.poll();
            if(visited[curr.dest]) continue;
            visited[curr.dest] = true;
            ans = Math.max(ans, curr.wt);
            nodes++;

            for(Pair nebr: graph.get(curr.dest)){
                if(visited[nebr.dest]) continue;
                pq.add(new Pair(nebr.dest,curr.wt + nebr.wt));
            }
        }

        if(nodes == n) return ans;
        return -1;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int time[]: times){
            graph.get(time[0]-1).add(new Pair(time[1]-1, time[2]));
        }

        return traverse(k-1, n);
    }
}
