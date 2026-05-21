class Solution {

    public boolean compareAndUpdate(String a, String b, HashMap<Character, Integer> id, List<List<Integer>> graph){
        int i = 0;
        int j = 0;

        if(a.length() > b.length() && a.startsWith(b))
            return false;

        while(i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
                continue;
            }
            else{
                int first = id.get(a.charAt(i));
                int second = id.get(b.charAt(j));
                if(!graph.get(first).contains(second)) graph.get(first).add(second);

                break;
            }
        }
        return true;
    }

    public String foreignDictionary(String[] words) {
        int n = words.length;
        HashMap<Character, Integer> siz = new HashMap<>();
        for(String word: words){
            for(char ch: word.toCharArray()){
                siz.put(ch, siz.getOrDefault(ch, 0)+1);
            }
        }

        HashMap<Character, Integer> id = new HashMap<>();
        int p = 0;
        for(Character ch: siz.keySet()){
            id.put(ch, p++);
        }

        int num = siz.size();

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<num; i++) graph.add(new ArrayList<>());

        for(int i=0; i<n-1; i++){
            String a = words[i];
            String b = words[i+1];

            if(!compareAndUpdate(a, b, id, graph))
                return "";
        }

        int indegree[] = new int[num];

        for(int i=0; i<num; i++){
            for(int nebr: graph.get(i)){
                indegree[nebr]++;
            }
        }

        StringBuilder ans = new StringBuilder();
        Queue<Integer> qu = new LinkedList<>();

        for(int i=0; i<num; i++){
            if(indegree[i] == 0){
                qu.add(i);
            }
        }

        while(qu.size() > 0){
            int curr = qu.poll();

            for(char c: id.keySet()){
                if(id.get(c)==curr){
                    ans.append(c);
                    break;
                }
            }

            for(int nebr: graph.get(curr)){
                indegree[nebr]--;
                if(indegree[nebr] == 0){
                    qu.add(nebr);
                }
            }
        }

        if(ans.length()!=num) return "";

        return ans.toString();
    }
}
