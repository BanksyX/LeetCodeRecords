/*
* 这道题，环形链表II；
* 是原来那道判断是否为环形链表的题的进阶版；因为还需要返回环形入口处节点；
* 对于这种链表上的操作，特贴是带环的，常用两种处理方案；
* 1、很好实现和理解的，HashSet哈希集合，集合内部保证元素的唯一性；
* 2、双指针，快慢指针遍历，快慢指针也是用来判断是否存在环的常用方法；
* */

// 下面是第一种方法，快慢指针
// 快慢指针的基本逻辑是，先确定是否存在环，即快慢指针是否会相遇
// 如果相遇了，那么必然存在环，那么接下来只需要寻找接入点
//public class Solution_142 {
//
//    public ListNode detectCycle(ListNode head){
//        ListNode fast = head, slow = head;
//        while (fast!=null && fast.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if (fast == slow){
//                ListNode index1 = head;
//                ListNode index2 = fast;
//                while (index1!=index2){
//                    index1 = index1.next;
//                    index2 = index2.next;
//                }
//                return index1;
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 142");
//    }
//}


import java.util.HashSet;

// 下面是利用hashset集合来进行处理，集合能保证元素的唯一性；
public class Solution_142 {

    public ListNode detectCycle(ListNode head){
        HashSet<ListNode> nodeSet = new HashSet<ListNode>();
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = dummyNode;

        while (cur.next!=null){
            if (nodeSet.contains(cur.next)){
                return cur.next;
            }
            cur = cur.next;
            nodeSet.add(cur);
        }
        return  null;
    }

    public static void main(String[] args) {
        System.out.println("Hello, 142!");
    }
}































