class LRUCache {

    public class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    HashMap<Integer, Node> mapp = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int maxx;

    public void add(Node root){
        Node temp = head.next;
        head.next = root;
        root.prev = head;
        root.next = temp;
        temp.prev = root;
    }

    public void delete(Node root){
        Node prv = root.prev;
        Node nxt = root.next;
        prv.next = nxt;
        nxt.prev = prv;
    }

    public LRUCache(int capacity) {
        mapp.clear();
        head.next = tail;
        tail.prev = head;
        maxx = capacity;
    }
    
    public int get(int key) {
        int val;
        if(mapp.containsKey(key)){
            val = mapp.get(key).val;
            Node temp = mapp.get(key);
            delete(temp);
            add(temp);
        }
        else return -1;

        return val;
    }
    
    public void put(int key, int value) {
        if(mapp.containsKey(key)){
            // update
            Node temp = mapp.get(key);
            delete(temp);
            temp.val = value;
            add(temp);
            mapp.put(key, temp);
        }
        else{
            if(mapp.size() == maxx){
                mapp.remove(tail.prev.key);
                delete(tail.prev);
                Node nw = new Node(key, value);
                add(nw);
                mapp.put(key, nw);
            }
            else{  
                Node nw = new Node(key, value);
                add(nw);
                mapp.put(key, nw);
            }
        }
    }
}
