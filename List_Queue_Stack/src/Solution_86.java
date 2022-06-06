/*
* 分隔链表
* 基本思想就是，构建两个链表
* 大链表用来保存大于等于特定值的元素
* 小链表用来保存小于特定值的元素
* 然后将两个链表链接起来，就实现了
* 因为大链表保存的是大于等于特定值的元素，所以直接就保存了初始相对位置
* */

/*
*
* 这个题还是比较简单，基本也是一遍过；
* */

//
//public class Solution_86 {
//
//    public ListNode partition(ListNode head, int x){
//        ListNode listSmall = new ListNode(0);
//        ListNode smallTail = listSmall;
//        ListNode listBigger = new ListNode(0);
//        ListNode biggerTail = listBigger;
//        ListNode temp = head;
//        while (temp!=null){
//            if (temp.val < x){
//                smallTail.next = temp;
//                smallTail = smallTail.next;
//            }else {
//                biggerTail.next = temp;
//                biggerTail = biggerTail.next;
//            }
//            temp = temp.next;
//        }
//
//        smallTail.next = listBigger.next;
//        biggerTail.next = null;
//
//        return listSmall.next;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 86!");
//    }
//
//}










