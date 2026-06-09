class Solution {

    public class Pair{
        int enq;
        int pro;
        int idx;

        Pair(int enq, int pro, int idx){
            this.enq = enq;
            this.pro = pro;
            this.idx = idx;
        }
    }

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->{
            if(a.enq == b.enq){
                return a.pro - b.pro;
            }
            return a.enq - b.enq;
        });

        boolean visited[] = new boolean[tasks.length];

        for(int i=0; i<tasks.length; i++){
            int e = tasks[i][0];
            int p = tasks[i][1];
            pq.add(new Pair(e, p, i));
        }

        int ans[] = new int[tasks.length];
        int a = 0;

        while(pq.size() > 0){
            Pair curr = pq.poll();
            ans[a++] = curr.idx;
            visited[curr.idx] = true;

            int tim = curr.pro;
            int enq = curr.enq;

            pq.clear();

            for(int i=0; i<tasks.length; i++){
                tasks[i][0] -= (tim + enq);
                if(tasks[i][0] < 0) tasks[i][0] = 0;

                int e = tasks[i][0];
                int p = tasks[i][1];
                if(!visited[i]) pq.add(new Pair(e, p, i));
            }
        }

        return ans;
    }
}