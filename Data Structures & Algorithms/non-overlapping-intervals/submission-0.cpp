class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& nums) {
        if (nums.empty()) return 0;
        sort(nums.begin(), nums.end(), [](auto &a, auto &b) {
            return a[1] < b[1];
        });

        int n = nums.size();
        int count = 0;
        int prev = nums[0][1];
        for(int i=0; i<n-1; i++){
            if(nums[i+1][0] < prev){
                count++;
            }
            else{
                prev = nums[i+1][1];
            }
        }
        return count;
    }
};