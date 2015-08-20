public class LRUCache {
    class Node{
        private Node prev, next;
        private int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        void insert(Node other){
            other.next = this.next;
            other.prev = this;
            this.next = other;
            other.next.prev = other;
        }
        
        Node delete(){
            this.prev.next = this.next;
            this.next.prev = this.prev;
            return this;
        }
    }
    
    Node head, tail;
    int n, m;
    Map<Integer, Node> hashMap;
    
    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        n = 0;
        m = capacity;
        hashMap = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (!hashMap.containsKey(key))
            return -1;
        Node temp = hashMap.get(key);
        temp.delete();
        head.insert(temp);
        return temp.value;
    }
    
    public void set(int key, int value) {
        if (hashMap.containsKey(key)){
            Node temp = hashMap.get(key);
            temp.delete();
            temp.value = value;
            head.insert(temp);
        } else {
            if (n == m) {
                Node temp = tail.prev.delete();
                hashMap.remove(temp.key);
                n--;
            }
            Node temp = new Node(key, value);
            head.insert(temp);
            hashMap.put(key, temp);
            n++;
        }
    }
}
