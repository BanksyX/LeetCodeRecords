// 232 用栈实现队列

/*
* 关于用两个栈来实现队列；
* 逻辑很清楚，元素先经过第一个栈，再进入另外一个栈即可；
* 所以关键是怎么把代码写好；
* 设置两个栈，输入栈和输出栈；
* 代码关键一点在于，只有在输出栈为空时，输入栈中元素才可以往输出栈中转移元素；
* 否则就不能转移元素；
*/

// 代码写的比较混乱，重新写一下；

//import java.util.Stack;
//
//public class Solution_232 {
//
//    private Stack<Integer> a;
//    private Stack<Integer> b;
//
//    public Solution_232(){
//        a = new Stack<>();
//        b = new Stack<>();
//    }
//
//    public void push(int val){
//        while (!a.isEmpty()){
//            b.push(a.pop());
//        }
//        a.push(val);
//    }
//
//    public void pop(){
//        if (!b.isEmpty())
//            b.pop();
//        else if (!a.isEmpty()){
//            while (!a.isEmpty())
//                b.push(a.pop());
//        }
//        b.pop();
//    }
//
//    public int peek(){
//        if (!b.isEmpty())
//            b.pop();
//        else if (!a.isEmpty()){
//            while (!a.isEmpty())
//                b.push(a.pop());
//        }
//        b.peek();
//    }
//
//    public boolean empty(){
//        return a.isEmpty() && b.isEmpty();
//    }
//}


import java.util.Stack;

public class Solution_232 {

    private Stack<Integer> a;
    private Stack<Integer> b;

    public Solution_232(){
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int val){
        a.push(val);
    }

    public int pop(){
        if (b.isEmpty()){
            while (!a.isEmpty())
                b.push(a.pop());
        }
        return b.pop();
    }

    public int peek(){
        if (b.isEmpty()){
            while (!a.isEmpty())
                b.push(a.pop());
        }
        return b.peek();
    }

    public boolean empty(){
        return a.isEmpty() && b.isEmpty();
    }
}























