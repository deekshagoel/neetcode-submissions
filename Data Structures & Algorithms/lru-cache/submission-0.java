class LRUCache {

    class Node{
        int key; int value; Node prev; Node next;
    

     public Node(int key, int val) {
        this.key = key;
        this.value = val;
        this.prev = null;
        this.next = null;
    }
    }


    int cap;
    HashMap<Integer, Node> cache;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap();
        left = new Node(0,0);
        right= new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            insert(node);
        }else{
            Node node = new Node(key, value);
            cache.put(key, node);
            insert(node);
        }

        if(cache.size() > cap){
            int firstKey = left.next.key;
            remove(left.next);
            cache.remove(firstKey);
            System.out.println(cache.get(left.next.key));
        }
    }

    void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    void insert(Node node){
        Node last = right.prev;
        last.next = node;
        node.prev = last;
        node.next = right;
        right.prev = node;
    }
}
