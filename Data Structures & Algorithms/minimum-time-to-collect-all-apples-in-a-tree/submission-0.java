class Solution {

    int ans = 0;

    List<List<Integer>> graph;

    public int dfs(boolean visited[], int src, int apple[]){

        int count = 0;

        visited[src] = true;

        for(int nebr: graph.get(src)){
            if(!visited[nebr]){
                int temp = dfs(visited, nebr, apple);

                if(temp > 0 || apple[nebr]==1){
                    count += temp + 2;
                }
            }
        }

        return count;
    }
    
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int apple[] = new int[n];
        for(int i=0; i<n; i++){
            if(hasApple.get(i)) apple[i] = 1;
            else apple[i] = 0;
        }

        graph = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean visited[] = new boolean[n];

        return dfs(visited, 0, apple);
    }
}