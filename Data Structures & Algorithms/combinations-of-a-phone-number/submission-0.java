class Solution {

    public void make(char nums[][], int dig[], List<String> ans, String temp, int a){
        if(temp.length() == dig.length){
            ans.add(temp);
            return;
        }

        int idx = dig[a]-2;

        for(int i=0; i<nums[idx].length; i++){
            make(nums, dig, ans, temp + nums[idx][i], a+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        char nums[][] = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
        {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        int dig[] = new int[digits.length()];
        for(int i=0; i<digits.length(); i++){
            dig[i] = (digits.charAt(i)-'0');
        }
        List<String> ans = new ArrayList<>();
        String temp = "";
        if(digits.length() == 0) return ans;

        make(nums, dig, ans, temp, 0);
        return ans;
    }
}
