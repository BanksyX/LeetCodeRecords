/*
* 这个224 简易计算器的实现；
* 虽然说感觉不难，也知道大致思路，通过栈来实现；
* 但是写起来发现还是逻辑不够清楚、且代码写不好；
* 现在发现，自己写代码，逻辑顺序理清楚很重要，如果逻辑混乱，那么代码肯定是写不出来的；
* 比如这里，关于如何设计栈以及如何对表达式进行读取和处理就有点模糊；
* 在逻辑清晰的情况下，基本是可以把代码写出来的
* 但是呢，这种情况下就可以看出代码能力了，代码能力不够强，那么也许代码能够写的通；
* 但是代码不一定高效简洁、美观；
* 所以，逻辑清晰是写出有效代码的前提，但是要写出更好的代码就需要更强的水平；
* */


/*
* 关于简易计算器；这是LeetCode里的Hard题哈哈哈；其实逻辑理清楚了就还好吧；
* 基本思路如下：
* 本质上就是字符串表达方式的转换；
* 人类使用的算式是中缀表达式的
* 如果要让计算机进行处理，最好转换为后缀表达式；
* 所以，这里的基本步骤就是；
* 1、先将原始中缀表达式转换为后缀表达式；
* 2、然后将后缀表达式进行计算
* 这里用到了两个栈；一个符号栈、一个数字栈；
* 第一步。中缀表达式转后缀表达式，
* 如果遇到了数字直接压入数字栈
* 如果遇到了符号，那么考虑符号类型；
* 如果符号优先级 比 符号栈栈顶元素优先级高，那就将当前符号压入栈；
* 如果比栈顶元素优先级低或者相等，那么就弹出符号栈栈顶元素即运算符，然后从数字栈中
* 取两个数进行计算，然后将结果压入数字栈中；
*
* 如果是遇到左括号，那么直接压入符号栈
* 如果遇到右括号，那么就从数字栈中弹出两个数字并从符号栈中弹出栈顶元素
* 然后将计算结果再次压入数字栈中，重复这步直到遇到左括号；
*
* 然后注意，因为这里只有加减号，所以不存在优先级的问题，省去了优先级的比较；
* */


/*
* 这下面的代码是先将 中缀表达式转换为后缀表达式 并存储起来；
* 然后对后缀表达式进行处理；
* 属于常规思路和方法，代码写起来比较复杂，但是可以掌握；
* */

//
//import java.util.Stack;
//
//public class Solution_224 {
//
//    private int[] findNextNumAndIndex(String s, int index){
//        int num = 0;
//        int i = index;
//        for (; i < s.length(); i++){
//            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
//                num = num * 10 + (s.charAt(i) - '0');
//            }else {
//                break;
//            }
//        }
//        int[] result = new int[2];
//        result[0] = num;
//        result[1] = i;
//        return result;
//    }
//
//    public int calculate(String s){
//        StringBuilder stringBuilder = new StringBuilder();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); ){
//            Character temp = s.charAt(i);
//            if (temp >= '0' && temp <= '9'){
//                int[] result = findNextNumAndIndex(s, i);
//                stringBuilder.append(result[0]);
//                stringBuilder.append(" ");
//                i = result[1];
//            }else if (temp == '('){
//                stack.push(temp);
//                i++;
//            }else if (temp == '+' || temp == '-'){
//                if (!stack.isEmpty()){
//                    while (!stack.isEmpty()){
//                        Character item = stack.pop();
//                        if (item == '('){
//                            stack.push(item);
//                            break;
//                        }else {
//                            stringBuilder.append(item);
//                            stringBuilder.append(" ");
//                        }
//                    }
//                }
//                stack.push(temp);
//                i++;
//            }else if (temp == ')' ){
//                Character item = stack.pop();
//                while (item!='('){
//                    stringBuilder.append(item);
//                    stringBuilder.append(" ");
//                    item = stack.pop();
//                }
//                i++;
//            }else {
//                i++;
//            }
//        }
//        while (!stack.isEmpty()){
//            stringBuilder.append(stack.pop());
//            stringBuilder.append(" ");
//        }
//        // 上面就是中缀表达式转换成后缀表达式
//        String[] strings = stringBuilder.toString().split(" ");
//        Stack<Integer> numStack = new Stack<>();
//        for (int i = 0; i < strings.length; i++) {
//            if (strings[i].charAt(0) == '+') {
//                int num1 = numStack.pop();
//                int num2 = numStack.pop();
//                numStack.push(num2 + num1);
//            } else if (strings[i].charAt(0) == '-') {
//                int num1 = numStack.pop();
//                int num2 = numStack.pop();
//                numStack.push(num2 - num1);
//            } else {
//                numStack.push(Integer.parseInt(strings[i]));
//            }
//        }
//        return numStack.pop();
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//
//import java.util.Stack;
//
//public class Solution_224 {
//    public int calculate(String s){
//
//        // 使用栈存储字符串表达式中的数字
//        Stack<Integer> stack = new Stack<>();
//        int length = s.length();
//        int res = 0;
//        int sign = 1;
//
//        for (int i = 0; i < length; i++){
//            char ch = s.charAt(i);
//            if (Character.isDigit(ch)){
//                int value = ch - '0';
//                while (i + 1 < length && Character.isDigit(s.charAt(i+1))){
//                    value = value*10 + (s.charAt(i+1) - '0');
//                    i++;
//                }
//                res = res + sign*value;
//            }else if (ch == '+'){
//                sign = 1;
//            }else if (ch == '-'){
//                sign = -1;
//            }else if (ch == '('){
//                stack.push(res);
//                stack.push(sign);
//                res = 0;
//                sign = 1;
//            }else if (ch == ')'){
//                int formerSign = stack.peek();
//                stack.pop();
//                int formerRes = stack.peek();
//                stack.pop();
//                res = formerRes + formerSign*res;
//            }
//        }
//        return res;
//    }
//}


/*
* 目前掌握的方法是这种，代码写起来最简单；
* 而且只需要一个栈即可实现；
* 之所以只需要一个栈，是因为1、无优先级的区分 2、运算符只有加减号，可以用+1、-1代替
* 基本思路就是 五个判断，判断是否为数字、是否为+、是否为-、是否为(、是否为)；
* 但是这种方法，
* */

/*
* 相应的还有另外一种思路，就是利用双栈来实现，一个数字栈、一个符号栈；
* 这种双栈的思想，本质上是将中缀表达式转换为后缀表达式，然后对后缀表达式进行计算；
* */

import java.util.Stack;

public class Solution_224 {
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int res = 0;
        int sign = 1;

        for (int i = 0; i < length; i++){
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                int val = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i+1))){
                    val = val*10 + (s.charAt(i+1) - '0');
                    i++;
                }
                res = res + sign * val;
            }else if (ch == '+'){
                sign = 1;
            }else if (ch == '-'){
                sign = -1;
            }else if (ch == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if (ch == ')'){
                int formersign = stack.peek();
                stack.pop();
                int formerres = stack.peek();
                stack.pop();
                res = formerres + formersign * res;
            }
        }
        return res;
    }
}





























