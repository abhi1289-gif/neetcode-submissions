class Solution {

    public String decode(String s){

        List<Integer> freq = new ArrayList<>();
        List<String> word = new ArrayList<>();

        int i = 0;

        while(i < s.length()){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                freq.add(1);
                word.add(Character.toString(s.charAt(i++)));
                continue;
            }
            else if(i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int num = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = num*10 + (int)(s.charAt(i++)-'0');
                }
                freq.add(num);
                int l = 1;
                i++;
                String temp = "";
                while(i<s.length() && l > 0){
                    if(s.charAt(i) == ']')l--;
                    else if(s.charAt(i) == '[')l++;
                    if(l==0){
                        i++;
                        break;
                    }
                    temp += s.charAt(i++);
                }

                String decoded = decode(temp);
                word.add(decoded);
            }
        }

        String ans = "";

        for(int j=0; j<freq.size(); j++){
            String temp = "";
            for(int k=0; k<freq.get(j); k++){
                temp += word.get(j);
            }
            ans += temp;
        }

        return ans;
    }

    public String decodeString(String s) {
        return decode(s);
    }
}