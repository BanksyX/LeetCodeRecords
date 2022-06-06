
/*
* 关于最小栈的实现；
* 这里可以采用自己建栈进行实现，也就是搭建一个原始的栈
* */

/*
* 关于自己建栈，其实以前在C、C++中经常自己写；
* 最重要是实现以下几个基本功能
* 1、一个Stack Node的实现，即一个栈元素的实现，在里面就需要判断栈是否初始化
* 2、push、pop、top三个基本操作的实现；
* 3、在以上三个基本操作的基础上，添加一些其他操作，比如最小、最大等；
* */
//
//import java.util.Stack;
//
//public class Solution_155 {
//
//    private Node head;
//
//    public void push(int val){
//        if (head == null)
//            head = new Node(val, val);
//        else
//            head = new Node(val, Math.min(val, head.min), head);
//    }
//
//    public void pop(){
//        head = head.next;
//    }
//
//    public int top(){
//        return head.val;
//    }
//
//    public int getMin(){
//        return head.min;
//    }
//
//    private class Node{
//        int val;
//        int min;    // 栈的每个元素中直接保存栈中最小值
//        Node next;
//
//        private Node(int val, int min){
//            this.val =val;
//            this.min = min;
//            this.next = null;
//        }
//        private Node(int val, int min, Node next){
//            this.val = val;
//            this.min = min;
//            this.next = next;
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//}

/*
* 本质上是用链表实现；
* */

public class Solution_155 {

    private Node head;

    public void push(int val){
        if (head == null){
            head = new Node(val, val);
        }else{
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop(){
        head = head.next;
    }

    public int top(){
        return head.val;
    }

    public int getMin(){
        return head.min;
    }

    private class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min){
            this.val = val;
            this.min = min;
            this.next = null;
        }
        public Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}






























