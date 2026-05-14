class Solution {
    public int longestConsecutive(int[] num) {
        ArrayList<Integer> nums = new ArrayList<>();
        Arrays.sort(num);
        for(int i=0; i<num.length; i++){
            if(i>0 && num[i] == num[i-1]) continue;
            nums.add(num[i]);
        }
        Collections.sort(nums);
        int i = 0;
        int j = 0;
        int ans = 0;
        if(nums.size() < 2) return nums.size();

        while(j<nums.size()-1){
            if(nums.get(j)+1 == nums.get(j+1)){
                j++;
            }
            else{
                ans = Math.max(ans, j-i+1);
                j++;
                i = j;
            }
            
        }
        
        ans = Math.max(ans, j-i+1);
        return ans;
    }
}
