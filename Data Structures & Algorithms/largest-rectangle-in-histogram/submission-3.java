class Solution {

    public void nextSmaller(int nums[], int num1[]){
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            while(st.size() > 0 && nums[st.peek()] >= nums[i]) st.pop();
            if(st.size() == 0) num1[i] = nums.length;
            else num1[i] = st.peek();
            st.push(i);
        }
    }

    public void prevSmaller(int nums[], int num2[]){
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(st.size() > 0 && nums[st.peek()] >= nums[i]) st.pop();
            if(st.size() == 0) num2[i] = -1;
            else num2[i] = st.peek();
            st.push(i);
        }
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int num1[] = new int[n];
        int num2[] = new int[n];

        nextSmaller(heights, num1);
        prevSmaller(heights, num2);

        int ans = 0;

        for(int i=0; i<n; i++){
            ans = Math.max(ans, heights[i]*(num1[i]-num2[i]-1));
        }

        return ans;
    }
}
