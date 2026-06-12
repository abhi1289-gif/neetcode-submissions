class Solution {

    public class Trie{
        String val;
        boolean leaf;
        HashMap<String, Trie> mapp = new HashMap<>();

        Trie(String val){
            this.val = val;
            this.leaf = false;
        }
    }

    Trie root = new Trie("0");

    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);

        for(String s: folder){
            Trie temp = root;
            String[] str = s.split("/");

            boolean need = true;

            for(String a: str){
                if(!temp.mapp.containsKey(a)){
                    Trie t = new Trie(a);
                    temp.mapp.put(a, t);
                }

                temp = temp.mapp.get(a);
                if(temp.leaf){
                    need = false;
                    continue;
                }
            }
            temp.leaf = true;
            if(need) ans.add(s);
        }

        return ans;
    }
}