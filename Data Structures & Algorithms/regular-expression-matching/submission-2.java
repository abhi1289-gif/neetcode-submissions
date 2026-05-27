class Solution {

    public boolean make(String s, String p, int i, int j){
        
        if(j == p.length()) return i == s.length();

        boolean first = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            return make(s, p, i, j+2) || (first && make(s, p, i+1, j));
        }

        return first && make(s, p, i+1, j+1);
    }

    public boolean isMatch(String s, String p) {
        return make(s, p, 0, 0);
    }
}
