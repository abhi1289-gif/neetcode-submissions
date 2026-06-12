class StockSpanner {

    Stack<Integer> st = new Stack<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        Stack<Integer> temp = new Stack<>(); 
        int ans = 1;

        while(st.size() > 0 && st.peek() <= price){
            temp.add(st.pop());
            ans++;
        }

        while(temp.size() > 0){
            st.add(temp.pop());
        }

        st.add(price);

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */