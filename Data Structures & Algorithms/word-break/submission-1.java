class Solution {

    Boolean dp[];

    public boolean check(String s, int i, List<String> wordDict, int k){
        if(i == s.length()) return true;
        if(dp[i] != null) return dp[i];

        String word = wordDict.get(k);

        if(s.length()-i < word.length()) return false;

        int t = 0;
        while(i < s.length() && t < word.length()){
            if(s.charAt(i) != word.charAt(t)) return false;
            i++;
            t++;
        }
        if(i == s.length()) return true;

        for(int j=0; j<wordDict.size(); j++){
            String nxtWord = wordDict.get(j);
            if(s.charAt(i) != nxtWord.charAt(0)) continue;

            if(check(s, i, wordDict, j)) return dp[i] = true;
        }

        return dp[i] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        dp = new Boolean[s.length()];
        for(int i=0; i<n; i++){
            if(check(s, 0, wordDict, i)) return true;
        }
        return false;
    }
}
