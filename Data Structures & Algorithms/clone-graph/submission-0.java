/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node make(Node node, HashMap<Node, Node> mapp){
        Node newNode = new Node(node.val);
        mapp.put(node, newNode);

        for(Node nebr: node.neighbors){
            if(!mapp.containsKey(nebr)){
                newNode.neighbors.add(make(nebr, mapp));
            }
            else{
                newNode.neighbors.add(mapp.get(nebr));                
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> mapp = new HashMap<>();
        return make(node, mapp);
    }
}