class StockSpanner {

    Stack<int[]> st = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        
        int ans = 1;

        while(st.size() > 0 && st.peek()[0] <= price){
            ans += st.peek()[1];
            st.pop();
        }

        st.add(new int[]{price, ans});

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */