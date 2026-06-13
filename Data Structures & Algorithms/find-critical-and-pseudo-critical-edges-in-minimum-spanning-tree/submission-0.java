class Solution {

    public static class Edge{
        int a;
        int b;
        int wt;
        int idx;

        Edge(int a, int b, int wt, int idx){
            this.a = a;
            this.b = b;
            this.wt = wt;
            this.idx = idx;
        }
    }

    public static int find(int a, int parent[]){
        return parent[a] = (parent[a] == a)? a: find(parent[a], parent);
    }

    public static void unite(int a, int b, int parent[], int rank[]){
        a = find(a, parent);
        b = find(b, parent);

        if(rank[a]>rank[b]){
            parent[b] = a;
        }
        else if(rank[a]<rank[b]){
            parent[a] = b;
        }
        else{
            parent[b] = a;
            rank[a]++;
        }
    }

    public static int kruskal(Edge edges[], int n){

        int parent[] = new int[n];
        int rank[] = new int[n];

        for(int i=0; i<n; i++) parent[i] = i;

        int count = 0;
        int i = 0;
        int weight = 0;

        while(count < n-1 && i < edges.length){
            Edge curr = edges[i];

            int apar = find(curr.a, parent);
            int bpar = find(curr.b, parent);

            if(apar != bpar){
                unite(curr.a, curr.b, parent, rank);
                count++;
                weight += curr.wt;
            }
            i++;
        }
        return (count == n-1)? weight: -1;
    }

    public static int forcedKruskal(Edge edges[], int n, int forced){

        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        Edge f = edges[forced];
        unite(f.a, f.b, parent, rank);

        int count = 1;
        int i = 0;
        int weight = f.wt;

        while(count < n-1 && i < edges.length){
            Edge curr = edges[i];

            int apar = find(curr.a, parent);
            int bpar = find(curr.b, parent);

            if(apar != bpar){
                unite(curr.a, curr.b, parent, rank);
                count++;
                weight += curr.wt;
            }
            i++;
        }
        return (count == n-1)? weight: -1;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> crit = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        int e = edges.length;

        Edge v[] = new Edge[e];


        for(int i=0; i<e; i++){
            Edge temp = new Edge(edges[i][0], edges[i][1], edges[i][2], i);
            v[i] = temp;
        }
        Arrays.sort(v, (a, b)-> Integer.compare(a.wt, b.wt));

        int kruVal = kruskal(v, n);

        for(int i=0; i<e; i++){
            Edge vi[] = new Edge[e-1];
            int idx = 0;
            for(int j=0; j<e; j++){
                if(i == j){
                    continue;
                }
                vi[idx++] = v[j];
            }
            int val = kruskal(vi, n);
            if(kruVal < val || val == -1) crit.add(v[i].idx);
            else if(kruVal == forcedKruskal(v, n, i)) pseudo.add(v[i].idx);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(crit);
        ans.add(pseudo);

        return ans;
    }
}