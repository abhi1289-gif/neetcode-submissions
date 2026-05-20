class Solution {

    public int find(int a, int parent[]){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a], parent);
    }

    public void unite(int a, int b, int parent[], int rank[]){
        a = find(a, parent);
        b = find(b, parent);

        if(rank[a] > rank[b]){
            parent[b] = a;
        }
        else if(rank[a] < rank[b]){
            parent[a] = b;
        }
        else{
            parent[b] = a;
            rank[a]++;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int edge[]: edges){
            int a = edge[0];
            int b = edge[1];

            a = find(a, parent);
            b = find(b, parent);

            if(a == b) return false;

            unite(edge[0], edge[1], parent, rank);
        }

        return true;
    }
}
