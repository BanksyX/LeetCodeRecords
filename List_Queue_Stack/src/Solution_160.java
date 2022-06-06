//public class Solution_160 {
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//
//        ListNode tempA = headA;
//        ListNode tempB = headB;
//
//        while (tempA.next!=null && tempB.next!=null){
//            tempA = tempA.next;
//            tempB = tempB.next;
//        }
//        if (tempA.next == null)
//            tempA.next = headB;
//        if (tempB.next == null)
//            tempB.next = headA;
//
//        while (tempA.next!=null && tempB.next!=null){
//            tempA = tempA.next;
//            tempB = tempB.next;
//        }
//        if (tempA.next == null)
//            tempA.next = headB;
//        if (tempB.next == null)
//            tempB.next = headA;
//
////        if (tempA.next!=null && tempB.next!=null && tempA.next.val == tempB.next.val)
//        return tempA.next;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

// 上面这段代码吧，逻辑是对的，但是写的不好，容易超时，需要进行优化，

// 下面就是上面逻辑的合理实现，也就是常见的双指针情况，设定两个指针pointA和pointB

//public class Solution_160 {
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//
//        if (headA == null || headB == null)
//            return null;
//
//        ListNode pointA = headA;
//        ListNode pointB = headB;
//
//        while (pointA!=pointB){
//            if (pointA!=null){
//                pointA = pointA.next;
//            }else {
//                pointA = headB;
//            }
//
//            if (pointB!=null){
//                pointB = pointB.next;
//            }else {
//                pointB = pointA;
//            }
//        }
//
//        return pointA;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

// 下面就是双指针的简洁代码表示
//public class Solution_160 {
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//        ListNode pointA = headA;
//        ListNode pointB = headB;
//        while (pointA!=pointB){
//            pointA = pointA==null? headB:pointA.next;
//            pointB = pointB==null? headA:pointB.next;
//        }
//        return pointA;
//    }
//    public static void main(String[] args) {
//        System.out.println("Hello, 160!");
//    }
//}


/*
* 还有另外一种实现逻辑，自己之前最开始想到的是这种
* 也就是先求出两个链表A、B的长度，然后计算链表相差的长度
* 但是因为给定的是一个ListNode，并没有自带的计算length的函数，所以当时没想
*  */

//public class Solution_160 {
//
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
//        int len1=0, len2=0, diff=0;
//        ListNode head1 = headA, head2 = headB;
//        while (head1!=null){
//            len1++;
//            head1=head1.next;
//        }
//        while (head2!=null){
//            len2++;
//            head2=head2.next;
//        }
//
//        head1 = headA;
//        head2 = headB;
//
//        if (len1 > len2){
//            diff = len1 - len2;
//            for (int i = 0; i < diff; i++)
//                head1 = head1.next;
//        }else {
//            diff = len2 - len1;
//            for (int i = 0; i < diff; i++)
//                head2 = head2.next;
//        }
//
//        if (len1<len2){
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 160");
//    }
//}

/*
* 官方给出了第三种解决方法，也就是利用HashSet哈希集合
* 首先遍历链表A，将A中的每一个节点都放入哈希集合中，然后遍历B中每一个节点
* 如果当前B中节点不在哈希集合中，那么继续遍历下一个
* 如果当前节点在哈希集合中，那么就代表这是第一个交点，也就是我们要找的
* 如果B中所有节点都不在集合中，那么两个链表不相交，返回null
*
* 这种解决方法也表示一种信息，即，A、B链表中元素如果不相交，那么元素就都不会重复
*
* */

// 虽然HashSet思路写起来很简单，但是根据提交情况来看，HashSet耗时较长

import java.util.HashSet;

public class Solution_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        HashSet<ListNode> visitedSet = new HashSet<ListNode>();
        ListNode point = headA;
        while (point!=null){
            visitedSet.add(point);
            point = point.next;
        }

        point = headB;
        while (point!=null){
            if (visitedSet.contains(point)){
                return point;
            }
            point = point.next;
        }
        return null;
    }
}
















