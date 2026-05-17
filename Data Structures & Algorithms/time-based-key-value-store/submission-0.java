class TimeMap {

    public class Pair{
        String val;
        int ts;

        Pair(String val, int ts){
            this.val = val;
            this.ts = ts;
        }
    }

    HashMap<String, ArrayList<Pair>> mapp = new HashMap<>(); 

    public TimeMap() {
        mapp.clear();
    }
    
    public void set(String key, String value, int timestamp) {
        mapp.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

        if(!mapp.containsKey(key))
            return "";

        ArrayList<Pair> nums = mapp.get(key);
        int i = 0;
        int j = nums.size()-1;
         String ans = "";
        while(i <= j){
            int mid = i + (j-i)/2;
            
            if(timestamp >= nums.get(mid).ts){
                ans = nums.get(mid).val;
                i = mid+1;
            }
            else j = mid-1;
        }
        return ans;
    }
}
