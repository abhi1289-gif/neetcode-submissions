class Solution {

    class Pair{
        long dist;
        int idx;

        Pair(long dist, int idx){
            this.dist = dist;
            this.idx = idx;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        for(int i=0; i<n; i++){
            int x = points[i][0];
            int y = points[i][1];
            long dist = x*x + y*y;
            pq.add(new Pair(dist, i));
        }

        int ans[][] = new int[k][2];
        int i = 0;
        while(i < k){
            Pair curr = pq.poll();
            int idx = curr.idx;
            ans[i][0] = points[idx][0];
            ans[i][1] = points[idx][1];
            i++;
        }

        return ans;
    }
}
