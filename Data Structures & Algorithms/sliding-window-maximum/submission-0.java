class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y)-> y-x);
        while(i<k){
            pq.add(nums[i]);
            i++;
        }
        int n = nums.length;
        int ans[] = new int[n-k+1];
        ans[0] = pq.peek();
        int p = 0;
        for(int j=k; j<n; j++){
            pq.remove(nums[p++]);
            pq.add(nums[j]);
            ans[j-k+1] = pq.peek();
        }

        return ans;
    }
}
