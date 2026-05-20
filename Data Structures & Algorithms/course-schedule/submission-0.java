class Solution {

    public boolean isPossible(int n, List<List<Integer>> graph){
        int indegree[] = new int[n];

        for(int i=0; i<n; i++){
            for(int nebr: graph.get(i)){
                indegree[nebr]++;
            }
        }

        int nodes = 0;

        Queue<Integer> qu = new LinkedList<>();

        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                qu.add(i);
                nodes++;
            }
        }

        while(qu.size() > 0){
            int curr = qu.poll();

            for(int nebr: graph.get(curr)){
                indegree[nebr]--;
                if(indegree[nebr] == 0){
                    qu.add(nebr);
                    nodes++;
                }
            }
        }

        return (nodes == n);
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]: prerequisites){
            int src = edge[0];
            int dest = edge[1];
            graph.get(src).add(dest);
        }

        return isPossible(n, graph);

    }
}
