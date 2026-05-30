class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> fo = new HashMap<>();
        HashMap<Character, Integer> lo = new HashMap<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(!fo.containsKey(ch)) fo.put(ch, i);

            lo.put(ch, i);
        }

        int i = 0;

        List<Integer> ans = new ArrayList<>();

        while(i < n){
            char ch = s.charAt(i);
            if(fo.get(ch) == lo.get(ch)){
                ans.add(1);
                i++;
                continue;
            }

            int start = i;
            int end = lo.get(ch);

            Queue<Character> qu = new LinkedList<>();
            while(i<=end){
                qu.add(s.charAt(i++));
            }

            while(qu.size() > 0){
                char curr = qu.poll();
                if(lo.get(curr) > end){
                    // add in queue;
                    end = lo.get(curr);
                    while(i<=end){
                        qu.add(s.charAt(i++));
                    }
                }
            }
            ans.add(i-start);
        }
        return ans;
    }
}
