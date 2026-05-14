class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> mapp = new HashMap<>();
        for(String s: strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String a = new String(arr);
            if(!mapp.containsKey(a)){
                mapp.put(a, new ArrayList<>());
            }
            mapp.get(a).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(ArrayList<String> list : mapp.values()){
            ans.add(list);
        }

        return ans;
    }
}
