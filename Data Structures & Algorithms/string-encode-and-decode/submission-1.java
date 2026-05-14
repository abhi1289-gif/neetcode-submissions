class Solution {

    public String encode(List<String> strs) {
        String ans = "";
        for(int i=0; i<strs.size(); i++){
            ans += strs.get(i);
            ans += "~";
        }
        return ans;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            String temp = "";
            while(j<str.length() && str.charAt(j) != '~'){
                temp += str.charAt(j);
                j++;
            }
            ans.add(temp);
            j++;
            i = j;
        }

        return ans;
    }
}
