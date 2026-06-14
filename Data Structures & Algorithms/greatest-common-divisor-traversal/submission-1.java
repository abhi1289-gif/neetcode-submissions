class Solution {

    public class Pair{
        int node;
        int wt;

        Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }
    }

    public int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a%b);
    }

    int ans = 0;

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public void dfs(int src, HashMap<Integer, Integer> visited){
        visited.put(src, 1);
        ans++;

        for(int nebr: graph.get(src)){
            if(!visited.containsKey(nebr)){
                dfs(nebr, visited);
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {

        int n = nums.length;

        for(int i=0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(gcd(nums[i], nums[j]) > 1){
                    if(!graph.containsKey(i)) graph.put(i, new ArrayList<>());
                    if(!graph.containsKey(j)) graph.put(j, new ArrayList<>());
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                } 
            }
        }

        HashMap<Integer, Integer> visited = new HashMap<>();

        if(!graph.containsKey(0)) return false;

        dfs(0, visited);

        if(ans == n) return true;

        return false;
        
    }
}