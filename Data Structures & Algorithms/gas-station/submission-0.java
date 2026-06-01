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

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++){
            if(isPossible(gas, cost, i)) return i;
        }

        return -1;
    }
}
