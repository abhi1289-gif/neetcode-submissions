class Solution {

    public static class Pair{
        int dest;
        int wt;
        int stops;

        Pair(int dest, int wt, int stops){
            this.dest = dest;
            this.wt = wt;
            this.stops = stops;
        }
    }

    static ArrayList<ArrayList<Pair>> graph;

    public static void addEdge(int src, int dest, int wt){
        graph.get(src).add(new Pair(dest, wt, 0));
    }

    public static int Dijkstra(int src, int n, int dest, int k){
        Queue<Pair> qu = new LinkedList<>();
        int dist[] = new int[n];
        for(int i=0; i<n; i++) dist[i] = Integer.MAX_VALUE;

        qu.add(new Pair(src, 0, 0));
        dist[src] = 0;

        while(qu.size() > 0){
            Pair curr = qu.poll();

            if(curr.stops>k) continue;


            for(Pair nebr: graph.get(curr.dest)){
                int newCost = curr.wt + nebr.wt;

                if(newCost<dist[nebr.dest]){
                    dist[nebr.dest]=newCost;
                    qu.add(new Pair(nebr.dest, newCost, curr.stops+1));
                }
            }
        }
        return dist[dest]==Integer.MAX_VALUE? -1: dist[dest];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int flight[]: flights){
            addEdge(flight[0], flight[1], flight[2]);
        }
        return Dijkstra(src, n, dst, k);
    }
}
