class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> mapp = new HashMap<>();
        for(int i=0; i<tasks.length; i++){
            mapp.put(tasks[i], mapp.getOrDefault(tasks[i], 0)+1);    
        }
        int maxx = 0;
        for(int freq: mapp.values()){
            maxx = Math.max(maxx, freq);
        }
        int num = 0;
        for(int freq: mapp.values()){
            if(freq == maxx) num++;
        }

        int result = maxx + (maxx-1)*n + num-1;
        return (result<tasks.length)? tasks.length: result;
    }
}
