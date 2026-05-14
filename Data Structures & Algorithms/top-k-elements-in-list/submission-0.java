class Solution {

    public class Pair{
        int a;
        int b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for(int i: nums){
            mapp.put(i, mapp.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y)-> y.b-x.b);
        for(int key: mapp.keySet()){
            pq.add(new Pair(key, mapp.get(key)));
        }
        int ans[] = new int[k];
        while(k != 0){
            ans[k-1] = pq.poll().a;
            k--;
        }

        return ans;
    }
}
