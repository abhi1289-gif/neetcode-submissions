class Solution {

    public int find(int a, int parent[]){
        return parent[a] = (parent[a] == a)? a: find(parent[a], parent);
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

    public int[] findRedundantConnection(int[][] edges) {

        int parent[] = new int[edges.length];
        int rank[] = new int[edges.length];

        for(int i=0; i<edges.length; i++) parent[i] = i;

        for(int edge[]: edges){
            int a = find(edge[0]-1, parent);
            int b = find(edge[1]-1, parent);

            if(a == b){
                return edge;
            }
            else{
                unite(edge[0]-1, edge[1]-1, parent, rank);
            }
        }

        return new int[]{-1, -1};
    }
}
