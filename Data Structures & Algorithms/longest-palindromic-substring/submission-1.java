class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2) return s;

        String ans = "" + s.charAt(0);
        int maxx = 1;

        // for odd
        for(int i=0; i<n; i++){
            int l = i-1;
            int r = i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(maxx < r-l+1){
                    ans = s.substring(l, r+1);
                    maxx = r-l+1;
                }
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
                if(maxx < r-l+1){
                    ans = s.substring(l, r+1);
                    maxx = r-l+1;
                }
                r++;
                l--;
            }
        }

        return ans;
    }
}
