class Solution {

    public class Pair{
        int val;
        int idx;
        Pair(int val, int idx){
            this.idx = idx;
            this.val = val;
        }
    }

    public int[] dailyTemperatures(int[] temp) {
        Stack<Pair> st = new Stack<>();

        int n = temp.length;
        int ans[] = new int[n];

        for(int i=n-1; i>=0; i--){
            while(st.size() > 0 && temp[i] >= st.peek().val) st.pop();

            if(st.size() == 0) ans[i] = 0;
            else{
                ans[i] = st.peek().idx-i;
            }
            st.push(new Pair(temp[i], i));
        }
        return ans;
    }
}
