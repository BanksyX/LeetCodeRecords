import java.util.*;

/*
* 关于这道 反转链表的题目
* 总共掌握了四种方式进行实现
* 1、常规方法，设置pre、cur、next三个节点进行遍历
* 2、设置一个dummy顶点，遍历链表，然后头插法从dummy开始建立一个新链表，这个新链表就是反转了的链表
* 3、自己创建一个stack，将链表放进去然后取出来就实现了反转
* 4、最后一种比较高级的，就是递归，一直递归到最后一个节点，然后回溯过程实现反转；
* */

// 下面是用常规方法来反转链表；设置三个指针，pre、cur、temp
//public class Solution_206 {
//    public ListNode reverseList(ListNode head){
//        ListNode pre = null;
//        ListNode cur = head;
//        ListNode temp = null;
//
//        while (cur != null){
//            temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//
//        return pre;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

//
//public class Solution_206 {
//
//    public ListNode reverseList(ListNode head){
//        Stack<ListNode> stack = new Stack<>();
//        ListNode cur = head;
//        ListNode temp, tail;
//
//        while (cur!=null){
//            stack.push(cur);
//            cur = cur.next;
//        }
//
//        cur = stack.pop();
//        tail = cur;
//
//        while (!stack.isEmpty()){
//             temp = stack.pop();
//             temp.next = null;
//             tail.next = temp;
//             tail = tail.next;
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

// 下面这种就是认为构建一个栈stack来进行存放；

//public class Solution_206 {
//
//    public ListNode reverseList(ListNode head){
//        Stack<ListNode> stack = new Stack<>();
//        while (head!=null){
//            stack.push(head);
//            head = head.next;
//        }
//
//        ListNode dummy = new ListNode(0);
//        ListNode temp = dummy;
//
//        while (!stack.isEmpty()){
//            temp.next = stack.pop();
//            temp = temp.next;
//        }
//
//        temp.next = null;
//        return dummy.next;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}

// 当然啦，最巧妙的还是之前那种递归的方式，一直递归到最后一个节点
public class Solution_206 {

    public ListNode reverseList(ListNode head){

        if (head == null || head.next == null)
            return head;

        ListNode cur = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return cur;
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}














