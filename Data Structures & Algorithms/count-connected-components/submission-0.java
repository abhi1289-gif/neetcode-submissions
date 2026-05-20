class Solution {

    List<List<Integer>> graph = new ArrayList<>();

    public void dfs(int src, boolean visited[]){
        visited[src] = true;

        for(int nebr: graph.get(src)){
            if(!visited[nebr]){
                dfs(nebr, visited);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int edge[]: edges){
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int ans = 0;
        boolean visited[] = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                ans++;
                dfs(i, visited);
            }
        }
        return ans;
    }
}
