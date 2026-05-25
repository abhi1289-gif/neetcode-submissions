class Solution {

    public void dfs(List<List<Integer>> graph, List<Integer> ans, int src){

        while(!graph.get(src).isEmpty()){
            int minn = graph.get(src).get(0);
            for(int nebr: graph.get(src)){
                minn = Math.min(minn, nebr);
            }
            graph.get(src).remove(Integer.valueOf(minn));
            dfs(graph, ans, minn);
        }

        ans.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Set<String> set = new HashSet<>();

        for(int i=0; i<tickets.size(); i++){
            String a = tickets.get(i).get(0);
            String b = tickets.get(i).get(1);

            set.add(a);
            set.add(b);
        }

        List<String> temp = new ArrayList<>();

        for(String s: set){
            temp.add(s);
        }

        Collections.sort(temp);

        int idx = 0;
        HashMap<String, Integer> naming = new HashMap<>();

        for(int i=0; i<temp.size(); i++){
            String a = temp.get(i);
            naming.put(a, i);
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<naming.size(); i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<tickets.size(); i++){
            String a = tickets.get(i).get(0);
            String b = tickets.get(i).get(1);

            int src = naming.get(a);
            int dest = naming.get(b);

            graph.get(src).add(dest);
        }

        List<Integer> ans = new ArrayList<>();

        int src = naming.get("JFK");

        dfs(graph, ans, src);

        HashMap<Integer,String> reverse = new HashMap<>();

        for(var e : naming.entrySet()){
            reverse.put(e.getValue(), e.getKey());
        }

        List<String> result = new ArrayList<>();

        for(int i=0; i<ans.size(); i++){
            result.add(reverse.get(ans.get(i)));
        }

        Collections.reverse(result);

        return result;
    }
}
