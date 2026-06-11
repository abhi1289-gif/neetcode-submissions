class Solution {

    public class Pair{
        String dest;
        double val;

        Pair(String dest, double val){
            this.dest = dest;
            this.val = val;
        }
    }

    HashMap<String, List<Pair>> graph = new HashMap<>();

    public String find(String a, HashMap<String, String> parent){
        if(parent.get(a).equals(a)) return a;

        parent.put(a, find(parent.get(a), parent));

        return parent.get(a);
    }

    public void unite(String a, String b, HashMap<String, String> parent){
        a = find(a, parent);
        b = find(b, parent);

        if(a.equals(b)) return;

        parent.put(a, b);
    }

    public double dist(String src, String dest, int n){
        Queue<String> qu = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Double> distance = new HashMap<>();

        visited.put(src, false);    
        qu.add(src);
        distance.put(src, 1.0);

        while(qu.size() > 0){
            String curr = qu.poll();
            if(visited.containsKey(curr) && visited.get(curr)) continue;
            if(distance.containsKey(dest)) return distance.get(dest);

            visited.put(curr, true);

            for(Pair nebr: graph.get(curr)){
                if(!visited.containsKey(nebr.dest)){
                    qu.add(nebr.dest);
                    visited.put(nebr.dest, false);
                    distance.put(nebr.dest, distance.get(curr)*nebr.val);
                }
            }
        }

        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, String> parent = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            if(!parent.containsKey(a)) parent.put(a, a);
            if(!parent.containsKey(b)) parent.put(b, b);

            unite(a, b, parent);

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Pair(b, values[i]));
            graph.get(b).add(new Pair(a, 1.0/values[i]));
        }

        double ans[] = new double[queries.size()];

        int n = graph.size();

        for(int i=0; i<queries.size(); i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            double res;
            if(!graph.containsKey(a) || !graph.containsKey(b)) res = -1.0;
            else if(!find(a, parent).equals(find(b, parent))) res = -1.0;
            else{
                res = dist(a, b, n);
            }
            ans[i] = res;      
        }

        return ans;
    }
}