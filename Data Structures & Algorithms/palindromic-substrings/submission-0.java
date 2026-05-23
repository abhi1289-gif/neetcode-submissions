class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n < 2){
            return n;
        }

        int ans = 0;

        // for odd
        for(int i=0; i<n; i++){
            ans++;
            int l = i-1;
            int r = i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                ans++;
                r++;
                l--;
            }
        }

        // for even
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) != s.charAt(i+1)) continue;
            int l = i;
            int r = i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                ans++;
                r++;
                l--;
            }
        }

        return ans;
    }
}
