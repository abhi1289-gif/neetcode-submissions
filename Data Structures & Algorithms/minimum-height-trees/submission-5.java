class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return Arrays.asList(0);
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offer(i);
            }
        }

        int remaining = n;

        while (remaining > 2) {

            int size = q.size();
            remaining -= size;

            for (int i = 0; i < size; i++) {

                int leaf = q.poll();

                for (int nbr : graph.get(leaf)) {

                    degree[nbr]--;

                    if (degree[nbr] == 1) {
                        q.offer(nbr);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}