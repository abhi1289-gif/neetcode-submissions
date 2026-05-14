class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int ans = 0;
        HashMap<Character, Integer> mapp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            mapp.put(ch, mapp.getOrDefault(ch, 0)+1);

            while(j<i && mapp.get(ch)>1){
                char a = s.charAt(j);
                mapp.put(a, mapp.get(a) - 1);
                j++;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }
}
