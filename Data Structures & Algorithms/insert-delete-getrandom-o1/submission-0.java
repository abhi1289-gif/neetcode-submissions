class RandomizedSet {

    Set<Integer> st;

    public RandomizedSet() {
        st = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(st.contains(val)) return false;
        st.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!st.contains(val)) return false;
        st.remove(val);
        return true;
    }
    
    public int getRandom() {
        int n = st.size();
        int x = (int)(Math.random() * n);

        for(int a: st){
            if(x==0) return a;
            x--;
        }

        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */