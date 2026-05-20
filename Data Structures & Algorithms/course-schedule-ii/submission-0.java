class Solution {

    public int make(int n, List<List<Integer>> graph, int ans[]){
        int indegree[] = new int[n];

        for(int i=0; i<n; i++){
            for(int nebr: graph.get(i)){
                indegree[nebr]++;
            }
        }

        int nodes = 0;

        Queue<Integer> qu = new LinkedList<>();
        int a = 0;

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                qu.add(i);
                nodes++;
                ans[a++] = i;
            }
        }

        while(qu.size() > 0){
            int curr = qu.poll();

            for(int nebr: graph.get(curr)){
                indegree[nebr]--;
                if(indegree[nebr] == 0){
                    qu.add(nebr);
                    nodes++;
                    ans[a++] = nebr;
                }
            }
        }

        return nodes;
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]: prerequisites){
            int src = edge[0];
            int dest = edge[1];
            graph.get(dest).add(src);
        }
        int ans[] = new int[n];
        int nodes = make(n, graph, ans);
        if(nodes != n) return new int[0];
        return ans;
    }
}
