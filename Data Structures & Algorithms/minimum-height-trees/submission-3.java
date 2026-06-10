class Solution {

    List<List<Integer>> graph;


    public int farthestLeaf(int src, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(new int[]{src, 0});
        visited[src] = true;

        int maxDist = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];

            // Leaf node
            if ((node == src && graph.get(node).size() == 0) ||
                (node != src && graph.get(node).size() == 1)) {
                maxDist = Math.max(maxDist, dist);
            }

            for (int nbr : graph.get(node)) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.offer(new int[]{nbr, dist + 1});
                }
            }
        }

        return maxDist;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        int indegree[] = new int[n];

        for(int edge[]: edges){
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);

            indegree[a]++;
            indegree[b]++;
        }

        int dist[] = new int[n];

        int minn = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            dist[i] = farthestLeaf(i, n);
            minn = Math.min(minn, dist[i]);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(minn == dist[i]) ans.add(i);
        }

        return ans;
    }
}