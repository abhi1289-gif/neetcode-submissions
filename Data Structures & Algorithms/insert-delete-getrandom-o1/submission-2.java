class RandomizedSet {

    HashMap<Integer, Integer> mapp;
    List<Integer> list;

    public RandomizedSet() {
        mapp = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(mapp.containsKey(val)) return false;
        list.add(val);
        mapp.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!mapp.containsKey(val)) return false;

        int idx = mapp.get(val);
        int cpy = list.get(list.size()-1);

        if (idx != list.size() - 1){
            list.set(idx, cpy);
            mapp.put(cpy, idx);
        }

        list.remove(list.size()-1);
        mapp.remove(val);
        return true;
    }
    
    public int getRandom() {
        int n = list.size();
        int x = (int)(Math.random() * n);

        return list.get(x);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */