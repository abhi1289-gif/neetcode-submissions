class Solution {

    public void make(int nums[], int t, List<Integer> temp, List<List<Integer>> ans, int start){
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(t < 0) return;

        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            t -= nums[i];
            make(nums, t, temp, ans, i);
            t += nums[i];
            temp.remove(temp.size()-1);
        }

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
         make(nums, target, temp, ans, 0);
        return ans;
    }
}
