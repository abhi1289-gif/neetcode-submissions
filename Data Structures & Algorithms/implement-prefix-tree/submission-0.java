class PrefixTree {

    class Tree{
        char val;
        boolean leaf;
        HashMap<Character, Tree> mapp = new HashMap<>();

        Tree(char val){
            this.val = val;
            leaf = false;
            this.mapp.clear();
        }
    }

    Tree root = new Tree('0');

    public PrefixTree() {
         
    }

    public void insert(String word) {
        Tree temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.mapp.containsKey(ch)){
                temp = temp.mapp.get(ch);
            }
            else{
                Tree a = new Tree(ch);
                temp.mapp.put(ch, a);
                temp = a;
            }
        }
        temp.leaf = true;
    }

    public boolean search(String word) {
        Tree temp = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.mapp.containsKey(ch)){
                temp = temp.mapp.get(ch);
            }
            else return false;
        }
        if(temp.leaf == false) return false;

        return true;
    }

    public boolean startsWith(String prefix) {
        Tree temp = root;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(temp.mapp.containsKey(ch)){
                temp = temp.mapp.get(ch);
            }
            else return false;
        }
        
        return true;
    }
}
