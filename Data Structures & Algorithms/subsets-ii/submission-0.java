class Solution {

    public void make(int nums[], int i, List<List<Integer>> ans, List<Integer> temp){
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        make(nums, i+1, ans, temp);
        temp.remove(temp.size()-1);

        while(i+1 < nums.length && nums[i] == nums[i+1]) i++;

        make(nums, i+1, ans, temp);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        make(nums, 0, ans, temp);
        return ans;
    }
}
