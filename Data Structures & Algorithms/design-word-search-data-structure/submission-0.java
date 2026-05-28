class WordDictionary {

    public class Tree{
        char val;
        boolean leaf;
        HashMap<Character, Tree> mapp = new HashMap<>();

        Tree(char val){
            this.val = val;
            leaf = false;
            mapp.clear();
        }
    }

    Tree root;

    public WordDictionary() {
        root = new Tree('0');
    }

    public void addWord(String word) {
        Tree temp = root;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            if(!temp.mapp.containsKey(ch)){
                Tree a = new Tree(ch);
                temp.mapp.put(ch, a);
                temp = a;
            }
            else{
                temp = temp.mapp.get(ch);
            }
        }
        temp.leaf = true;
    }

    public boolean isPossible(Tree temp, String word, int idx){
        if(temp == null) return false;
        if(idx == word.length()) return temp.leaf;


        if(word.charAt(idx) == '.'){
            for(var a: temp.mapp.entrySet()){
                if(isPossible(a.getValue(), word, idx+1)) return true;
            }
            return false;
        }

        return isPossible(temp.mapp.get(word.charAt(idx)), word, idx+1);
    }

    public boolean search(String word) {
        return isPossible(root, word, 0);
    }
}
