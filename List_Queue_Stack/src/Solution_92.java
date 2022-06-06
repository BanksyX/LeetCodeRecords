/*
* 这道 92，也是反转链表，是之前那道全局反转链表的进阶版；
* 之前那道，是反转整个链表，但是这道只需要反转中间部分链表；
* 目前解决方法有两种，
* 1、也是最常规的，就是单独把中间需要进行反转的取出来，反转之后再与前后节点相拼接
* 这种方法，逻辑上比较好理解，代码实现也还行，但是呢，总觉得很低效，因为我们相当于要遍历两次链表。取中间链表一次，然后反转一次。
* 2、第二种方法，就稍微好点，只需要遍历一次链表
* 就是遇到一个需要被反转的节点时，逐个反转然后拼接，这样一次遍历完就完成了中间部分的反转；
* 3、因为这个数据结构是局限在一个简单的单链表里面，如果是一个循环单链表就好了，也就是说如果我们能够知道头节点和尾节点的指针，借助尾指针会方便很多
* 头尾节点同时向中间进行汇合扫描，然后遇到了需要进行反转的节点，就进行头尾结点的交换。理论上也是可实现的。
* 4、自己手写了一遍，发现自己写出来的方法和上面提到的几种都不同，。。。
* 但是本质上和第二种一样，也是只需要遍历一遍
* 就是先进行遍历，遇到了需要反转的其实节点，就开始进入反转操作；
* 具体就是用头插法建立新链表，因为头插法建表本身就是逆序的，所以通过重新头插法建表就实现了反转
* 不过头插法之前，需要保存进入反转之前的最后一个节点和反转出来后的第一个节点，方便后面进行拼接；
* */

// 以下代码先是实现常规的反转操作；
// ......写了一个小时。。。虽说逻辑上是常规操作把，但是实现起来还是有些地方需要注意的。。。
// 中间对链表进行反转，是通过头插法进行见表；因为头插法见表自动产生的就是逆序链表；
// 关键就是写好头插法建表过程；
// 但是呢，这并不算是最好的实现

// 不过也通过这次认识到了 哑节点 得重要性，也就是定义一个 dummy node 通常 dummy node = head.next() 然后再定义一个 cur = dummy

//public class Solution_92 {
//
//    public ListNode reverseBetween(ListNode head, int left, int right){
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        int index = 1;
//
//        while (pre.next!=null){
//            if (index == left){
//                ListNode newList = new ListNode(0);
//                ListNode cur = pre.next;
//                ListNode tail = pre.next;
//                // 这个tail就是反转之后序列的最后一个节点，虽然在原序中是第一个，但因为是头插法见表，所以建成后他就是最后的
//                // tail的作用只有一个，起到拼接链表的作用，tail.next要连接第二段正常序列。
//                ListNode next = new ListNode(0);
//                while (index++<=right){
//                    next = cur.next;
//                    cur.next = newList.next;
//                    newList.next = cur;
//                    cur = next;
//                }
//                pre.next = newList.next;
//                tail.next = cur;
//                return dummy.next;
//            }
//            index++;
//            pre = pre.next;
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 92!");
//    }
//}

//import javax.swing.event.ListDataEvent;
//
//public class Solution_92 {
//
//    public ListNode reverseBetween(ListNode head, int left, int right){
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode pre = dummy;
//        int index = 1;
//
//        while (pre.next!=null){
//            if (index == left){
//                ListNode newList = new ListNode(0);
//                ListNode cur = pre.next;
//                ListNode tail = pre.next;
//                ListNode next = new ListNode(0);
//                while (index++<=right){
//                    next = cur.next;
//                    cur.next = newList.next;
//                    newList.next = cur;
//                    cur = next;
//                }
//                pre.next = newList.next;
//                tail.next = cur;
//                return dummy.next;
//            }
//            index++;
//            pre = pre.next;
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 92!");
//    }
//}

/*
* 上面是通过头插法临时建表从而实现反转的
* 但是LeetCode官方题解里面有更好的解决方案，也就是每次实现一个后面节点的前移
* 这样写代码更加简洁美观，可以考虑
* */

public class Solution_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (i = 1; i < left; i++)
            pre = pre.next;

        ListNode cur = pre.next;

        for (int j = left; j < right; j++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("Hello, 92");
    }
}
















