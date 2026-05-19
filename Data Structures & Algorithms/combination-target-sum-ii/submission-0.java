class Solution {

    public void make(int nums[], int t, List<Integer> temp, List<List<Integer>> ans, int start){
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(t < 0) return;

        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1])continue;

            temp.add(nums[i]);
            t -= nums[i];
            make(nums, t, temp, ans, i+1);
            t += nums[i];
            temp.remove(temp.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        make(nums, target, temp, ans, 0);
        return ans;
    }
}
