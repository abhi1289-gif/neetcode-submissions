class Solution {

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sort(int[] nums, int[] speed, int n){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i] > nums[j]){
                    swap(nums, i, j);
                    swap(speed, i, j);
                }
            }
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int nums[] = new int[n];

        int ans = 0;

        sort(position, speed, n);

        Stack<Double> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            double time = (double)(target - position[i])/speed[i];

            if(st.isEmpty() || time > st.peek()){
                st.push(time);
            }
        }

        return st.size();
    }
}
