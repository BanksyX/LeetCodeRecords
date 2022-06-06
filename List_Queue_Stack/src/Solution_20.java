/*
* 关于栈的基础题
* 括号匹配，经典题了
* */

import java.util.Stack;

/*
* 还是第一次用Java处理字符和字符串，所以一些API用的不是很熟
* Character、char、String这三类；
* 一般为了处理单个字符，可以考虑将String转换为char[] 数组，这样方便处理每个字符
* */

/*
* 虽然这种方法逻辑上容易想到，但是确是比较低效的。
* */

//public class Solution_20 {
//
//    public boolean isValid(String s){
//        if (s.length() % 2 != 0)
//            return false;
//
//        Stack<Character> stack = new Stack<>();
//        int len = s.length();
//        int i = 0;
//        char[] strings = s.toCharArray();
//        while (i<len){
//            char temp = strings[i];
//            if (temp == '(' || temp == '[' || temp == '{'){
//                stack.push(temp);
//            }else {
//                if (stack.isEmpty())
//                    return false;
//                char top = stack.peek();
//                if ((top == '(' && temp == ')') || (top == '[' && temp == ']') || (top == '{' && temp == '}'))
//                    stack.pop();
//                else
//                    return false;
//            }
//            i++;
//        }
//        return stack.isEmpty();
//    }
//    public static void main(String[] args) {
//        System.out.println("Hello, 20!");
//    }
//}

//public class Solution_20 {
//    public boolean isValid(String s){
//        if (s.length() % 2 != 0)
//            return false;
//        Stack<Character> stack = new Stack<>();
//        int len = s.length();
//        char[] S2C = s.toCharArray();
//        for (int i = 0; i < len; i++){
//            char temp = S2C[i];
//            if (temp == '(' || temp == '[' || temp == '{')
//                stack.push(temp);
//            else {
//                if (stack.isEmpty())
//                    return false;
//                char top = stack.peek();
//                if ( (top == '(' && temp == ')') || (top == '[' && temp == ']') || (top == '{' && temp == '}') )
//                    stack.pop();
//                else
//                    return false;
//            }
//        }
//        return stack.isEmpty();
//    }
//}

/*
* 下面提供了两种不同的思路；
* 第一种本质上和上面的差别不大，但是其奥妙在于不是将左括号压栈，而是将右括号压栈
* 这就能够降低比较次数
*
* 第二种就是另外一种更巧妙的思路了；
* 巧妙地利用了括号序列的对称性；
* 然后进行replace，如果replace最后的数组长度为0，那么就说明是true
* */

/*
* 下面这种代码写法就相当简洁了
* 但因为本质上和上面的差不多，所以效率并没有太大的提升
* */
//public class Solution_20 {
//    public boolean isValid(String s){
//        Stack<Character> stack = new Stack<>();
//        for (char c: s.toCharArray()){
//            if (c == '(') stack.push(')');
//            else if (c == '[') stack.push(']');
//            else if (c == '{') stack.push('}');
//            else if (stack.isEmpty() || c != stack.pop())return false;
//        }
//        return stack.isEmpty();
//    }
//}

/*
* 这是第三种思路；从length上着手；思路清奇，但是速度较慢。但是写法很nb
* */

public class Solution_20 {
    public boolean isValid(String s){
        int length = s.length() / 2;
        for (int i = 0; i < length; i++)
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        return s.length() == 0;
    }
}









































