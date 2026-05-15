class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int arr[] = new int[26];
        int len = s.length();
        int maxFreq = 0;
        int ans = 0;

        while(right < len){
            char ch = s.charAt(right);
            arr[(ch-'A')]++;
            maxFreq = Math.max(maxFreq, arr[(ch-'A')]);

            if((right-left+1)-maxFreq <= k){
                ans = Math.max(ans, right-left+1);
            }
            while(left < right && (right-left+1)-maxFreq > k){
                arr[(s.charAt(left)-'A')]--;
                left++;
            }

            right++;
        }

        return ans;
    }
}
