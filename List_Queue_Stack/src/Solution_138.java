import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;


/*
* 这道题其实还挺简单的。
* 关于复制一个新链表，但这个链表不是普通的链表，是含有其他更多属性的；
* 自然的就会想到要使用 HashMap，即一个映射机制；或者说是 字典机制；
*
* */

/*
*  这个HashMao的Key是存储原链表，value是存储新的链表
*  最开始时，value部分只有原始value，后面才会添加next point 和 random point
* */

//public class Solution_138 {
//
//    public Node copyRandomList(Node head){
//        HashMap<Node, Node> nodeHash = new HashMap<>();
//        Node cur = head;
//        while (cur!=null){
//            nodeHash.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//
//        while (cur!=null){
//            Node CurHashVal = nodeHash.get(cur);
//            Node NextHashKey = nodeHash.get(cur.next);
//            CurHashVal.next = NextHashKey;
//            CurHashVal.random = nodeHash.get(cur.random);
//            cur = cur.next;
//        }
//        return nodeHash.get(head);
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 138");
//    }
//}

/*
* 下面的是通过递归的方法深度拷贝 next指针和random指针
*
* */

/*
* 从LeetCode反馈的结果来看，这种递归创建拷贝的方法更加高效，空间上开销小于HashMap
* 而且写法简洁NB
* */

//public class Solution_138 {
//    HashMap<Node, Node> map = new HashMap<>();
//    public Node copyRandomList(Node head) {
//        return copy(head);
//    }
//
//    private Node copy(Node now){
//        if(now == null){
//            return null;
//        }
//        // 已经访问过now节点了
//        if(map.containsKey(now)){
//            return map.get(now);
//        }
//        Node news = new Node(now.val);
//        map.put(now, news);
//        news.next = copy(now.next);
//        news.random = copy(now.random);
//        return news;
//    }
//}

public class Solution_138 {

    HashMap<Node, Node> nodeHash = new HashMap<>();
    public Node copyRandomList(Node head){
        return copy(head);
    }

    public Node copy(Node now){

        if (now == null){
            return null;
        }

        if (nodeHash.containsKey(now))
            return nodeHash.get(now);

        Node node = new Node(now.val);
        nodeHash.put(now, node);
        node.next = copy(now.next);
        node.random = copy(now.random);
        return node;
    }
}


















