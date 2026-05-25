class Solution {

    public boolean areEqual(String a, String b){
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) == '*') continue;
            else if(a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }

    public int ladderLength(String bw, String ew, List<String> wordList) {
        int n = wordList.size();
        boolean visited[] = new boolean[n];

        Queue<String> qu = new LinkedList<>();
        qu.add(bw);

        boolean present = false;

        for(int i=0; i<n; i++){
            if(bw.equals(wordList.get(i))) visited[i] = true;
            if(ew.equals(wordList.get(i))) present = true;
        }

        if(!present) return 0;

        int ans = 1;

        while(qu.size() > 0){
            int siz = qu.size();
            while(siz > 0){
                String curr = qu.poll();
                if(curr.equals(ew)) return ans+1;

                for(int i=0; i<curr.length(); i++){
                    String t = curr.substring(0, i) + "*" + curr.substring(i+1);

                    for(int j=0; j<n; j++){
                        if(!visited[j] && areEqual(t, wordList.get(j))){
                            visited[j] = true;
                            qu.add(wordList.get(j));
                            if(wordList.get(j).equals(ew)) return ans+1;
                        }
                    }
                }
                siz--;
            }
            ans++;
        }

        return 0;
    }
}
