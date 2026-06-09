class Solution {

    public class Pair{
        int freq;
        char ch;

        Pair(int freq, char ch){
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> mapp = new HashMap<>();

        int maxx = 0;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            mapp.put(ch, mapp.getOrDefault(ch, 0)+1);
            maxx = Math.max(maxx, mapp.get(ch));
        }

        if(maxx > s.length()/2+1) return "";

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        for(var mp: mapp.entrySet()){
            pq.add(new Pair(mp.getValue(), mp.getKey()));
        }

        String ans = "";

        while(pq.size() > 1){
            Pair a = pq.poll();
            Pair b = pq.poll();

            ans += a.ch;
            ans += b.ch;

            if(a.freq-1 > 0) pq.add(new Pair(a.freq-1, a.ch));
            if(b.freq-1 > 0) pq.add(new Pair(b.freq-1, b.ch));
        }

        if(pq.size() > 0){
            Pair curr = pq.poll();
            if(curr.freq > 1) return "";
            else{
                if(ans.charAt(ans.length()-1) == curr.ch) return "";
                else{
                    ans += curr.ch;
                }
            }
        }

        return ans;
    }
}