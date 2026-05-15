class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        String ans = "";
        if(len1 < len2) return ans;
        int p=0;
        int arr[] = new int[128];

        while(p<len2){
            int idx = (t.charAt(p++));
            arr[idx]++;
        }

        int len = Integer.MAX_VALUE;

        for(int i=0; i<len1; i++){
            char ch = s.charAt(i);
            if(arr[ch] > 0){
                int[] temp = arr.clone();
                int j = i;
                int siz = len2;
                while(j<len1 && siz > 0){
                    if(temp[(s.charAt(j))] > 0 && siz > 0){
                        temp[(s.charAt(j))]--;
                        siz--;
                    }
                    j++;
                }
                if(siz == 0){
                    if(len > j-i){
                        len = j-i;
                        ans = s.substring(i, j);
                    }
                }
            }
        }
        return ans;
    }
}
