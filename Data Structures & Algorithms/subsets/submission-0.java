class Solution {

    public void make(int nums[], int i, List<List<Integer>> ans, List<Integer> temp){
        if(i == nums.length){
            ans.add(new ArrayList(temp));
            return;
        }

        make(nums, i+1, ans, temp);
        temp.add(nums[i]);
        make(nums, i+1, ans, temp);
        temp.remove(temp.size()-1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        make(nums, 0, ans, temp);
        return ans;
    }
}
