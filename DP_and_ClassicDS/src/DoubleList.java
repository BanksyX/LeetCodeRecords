public class DoubleList {

    public Node head, tail;
    public int size;

    public DoubleList(){
        this.size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addLast(Node x){
        x.next = tail;
        x.prev = tail.prev;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // 删除双链表中的某个元素
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除第一个元素
    public Node removeFirst(){
        if (head.next == tail)
            return null;
        Node next = head.next;
        remove(next);
        return next;
    }

    public int size(){
        return size;
    }
}
