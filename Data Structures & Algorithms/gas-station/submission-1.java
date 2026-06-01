class Solution {

    public boolean isPossible(int gas[], int cost[], int idx){
        int sum = 0;

        int temp = idx; 

        for(int i=idx; i<gas.length; i++){
            sum += gas[i];
            if(sum < cost[i]) return false;
            sum -= cost[i];
        }

        for(int i=0; i<idx; i++){
            sum += gas[i];
            if(sum < cost[i]) return false;
            sum -= cost[i];
        }

        return true;
    }

    public class Pair{
        int gas;
        int idx;
    
        Pair(int gas, int idx){
            this.gas = gas;
            this.idx = idx;
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> b.gas-a.gas);

        for(int i=0; i<gas.length; i++){
            pq.add(new Pair(gas[i], i));
        }
        while(pq.size() > 0){
            Pair curr = pq.poll();
            if(isPossible(gas, cost, curr.idx)) return curr.idx;
        }

        return -1;
    }
}
