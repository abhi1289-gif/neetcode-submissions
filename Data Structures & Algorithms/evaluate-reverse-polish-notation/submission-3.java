class Solution {

    public int converter(String s){
        int ans = 0;
        int i = 0;
        boolean flag = false;
        if(s.charAt(0)=='-'){
            flag = true;
            i = 1;
        }
        while(i<s.length()){
            ans = ans*10 + (s.charAt(i)-'0');
            i++;
        }
        if(flag) ans = ans*(-1);
        return ans;
    }

    public int calculate(Stack<Integer> st, String c){
        int a = st.pop();
        int b = st.pop();

        if(c.equals("+")) return b+a;
        else if(c.equals("-")) return b-a;
        else if(c.equals("*")) return b*a;
        return b/a;
    }

    public int evalRPN(String[] tokens) {
        int i = 0;
        Stack<Integer> st = new Stack<>();
        while(i < tokens.length){
            String curr = tokens[i];
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")){
                st.push(calculate(st, curr));
            }
            else{
                st.push(converter(tokens[i]));
            }
            i++;
        }

        return st.pop();
    }
}
