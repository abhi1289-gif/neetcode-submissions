class MinStack {

    ArrayList<Integer> nums = new ArrayList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int minn;

    public MinStack() {
        minn = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        nums.add(val);
        pq.add(val);
    }
    
    public void pop() {
        int val = nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        pq.remove(val);
    }
    
    public int top() {
        return nums.get(nums.size()-1);
    }
    
    public int getMin() {
        return pq.peek();
    }
}
