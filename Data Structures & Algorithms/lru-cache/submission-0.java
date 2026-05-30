class LRUCache {
    Node left;
    Node right;
    int capacity;
    int currSize;
    Map<Integer,Node> map;
    public LRUCache(int capacity) {
        this.left=new Node(-1,-1);
        this.right=new Node(-1,-1);
        this.capacity=capacity;
        this.currSize=0;
        this.left.next=this.right;
        this.right.prev=this.left;
        this.map=new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node node=new Node(key,value);
            insert(node);
            map.put(key,node);
            this.currSize++;
        }else{
            Node node=map.get(key);
            remove(node);
            insert(node);
            node.val=value;
        }
        if(currSize>capacity){
            Node nodeToEvict=this.left.next;
            int keyToEvict=nodeToEvict.key;
            remove(nodeToEvict);
            this.currSize--;
            map.remove(keyToEvict);
        }
    }

    private void remove(Node node){
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    private void insert(Node node){
        Node secondRight=right.prev;
        secondRight.next=node;
        node.prev=secondRight;
        node.next=right;
        right.prev=node;
    }
}


class Node{
    int key; 
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key=key;
        this.val=val;
        this.prev=null;
        this.next=null;
    }
}
