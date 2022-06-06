/*
 *这个合并升序链表还是挺简单的哈哈，一次就过了
 *
 * */


//public class Solution_21 {
//
//    public ListNode mergeTwoList(ListNode list1, ListNode list2){
//
//        ListNode newList = new ListNode(0);
//        ListNode temp = newList;
//
//        while (list1!=null && list2!=null){
//            if (list1.val < list2.val){
//                temp.next = list1;
//                temp = temp.next;
//                list1 = list1.next;
//            }else {
//                temp.next = list2;
//                temp = temp.next;
//                list2 = list2.next;
//            }
//        }
//
//        if (list1!=null){
//            while (list1!=null){
//                temp.next = list1;
//                temp = temp.next;
//                list1 = list1.next;
//            }
//        }
//        if (list2!=null){
//            while (list2!=null){
//                temp.next = list2;
//                temp = temp.next;
//                list2 = list2.next;
//            }
//        }
//
//        return newList.next;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 21!");
//    }
//}


/*
* 虽然说，上面的代码可以通过，效果也还行，但是呢还是不够简洁和完善；
* 比如，后面的未遍历完的节点的合并，其实不需要遍历合并，只需整个合并就可以了
* */

//
//public class Solution_21 {
//
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
//
//        ListNode newList = new ListNode(0);
//        ListNode cur = newList;
//
//        while (list1!=null && list2!=null){
//            if (list1.val < list2.val){
//                cur.next = list1;
//                cur = cur.next;
//                list1 = list1.next;
//            }else {
//                cur.next = list2;
//                cur = cur.next;
//                list2 = list2.next;
//            }
//        }
//
//        if (list1 == null){
//            cur.next = list2;
//        }else {
//            cur.next = list1;
//        }
//
//        return newList.next;
//    }
//}

/*
* 基于同样的逻辑，其实可以把代码写的更加简洁
* */

//public class Solution_21 {
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode newList = new ListNode(0);
//        ListNode cur = newList;
//
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//                cur.next = list1;
//                cur = cur.next;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                cur = cur.next;
//                list2 = list2.next;
//            }
//        }
//
//        cur.next = list1 != null ? list1 : list2;
//
//        return newList.next;
//    }
//}


/*
* 这道题还有一种递归写法，很多这种提都可以用递归来写，要尝试掌握
* */

public class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoLists(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }
}









