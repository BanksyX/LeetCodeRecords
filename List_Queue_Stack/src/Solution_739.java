/*
* 这道题就是进行了简单的包装
* 在一个数组中，找出每个index元素后面第一个比它大的元素的index位置；
* */

/*
* 最直观的就是双重循环了。。简单暴力，不要脑子就可以想到；
* */
/*
* 虽然实现起来简单。。。But! 时间损耗太严重了
* 双循环，导致最后耗时1552ms。。。
* */

//public class Solution_739 {
//    public int[] dailyTemperatures(int[] T){
//        int[] res = new int[T.length];
//        for (int i = 0; i < T.length - 1; i++){
//            for (int j = i+1; j < T.length; j++){
//                if (T[i] < T[j]) {
//                    res[i] = j - i;
//                    break;
//                }
//            }
//        }
//        res[T.length-1] = 0;
//        return res;
//    }
//}

/*
* 接下来另外一种实现方法；相比之下将会快很多很多；
* 这种方法主要是找规律来实现的；
* 上面的循环是从最开始进行遍历的；
* 这次我们将从最后面开始遍历；
* 那么每次res[i] 就只需要考虑 res[i+1]的值，是否为0或者其他值；
* 这种情况下，所需要比较的次数将会大大减少；
* 而且循环次数也会大大减少
* */

// 这种从后面开始考虑的思想，本质上是类似于动态规划的思想；

//public class Solution_739 {
//    public int[] dailyTemperature(int[] T){
//        int[] res = new int[T.length];
//        res[T.length-1] = 0;
//        for (int i = T.length - 2; i >= 0; i--){
//            for (int j = i+1; j < T.length; j += res[j]){
//                if (T[i] < T[j]) {
//                    res[i] = j - i;
//                    break;
//                }else if (res[j] == 0){
//                    res[i] = 0;
//                    break;
//                }
//            }
//        }
//        return res;
//    }
//}

import java.util.Stack;

/**
 * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
 * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
 * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
 * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
 * - 若T[i] < T[i+1]，那么res[i]=1；
 * - 若T[i] > T[i+1]
 *   - res[i+1]=0，那么res[i]=0;
 *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
 */

//public class Solution_739 {
//    public int[] dailyTemperature(int[] T){
//        int[] res = new int[T.length];
//        res[T.length - 1] = 0;
//        for (int i = T.length - 2; i >= 0; i--){
//            for (int j = i+1; j < T.length; j+=res[j]){
//                if (T[i] < T[j]){
//                    res[i] = j - i;
//                    break;
//                }else if (res[j] == 0){
//                    res[i] = 0;
//                    break;
//                }
//            }
//        }
//        return res;
//    }
//}

// 但是这道题据说还有用栈来实现的。
// 借助 单调递增栈来实现处理；可以在O(n)时间复杂度内完成，但是本质上是空间换时间
// 这里就更加侧重对于栈的利用
// 这个栈中，元素是有序排列的，从栈底到栈顶减小；栈中存放的是原数组索引
// 如果当前元素大于栈顶元素，说明比之前一天温度高的一天来了，
// 从而将栈顶元素弹出然后计算索引间距，然后继续将当前元素和栈顶元素比较看是否压入栈中

// 需要再次注意就是，栈里面存放的是 原数组的索引；
//public class Solution_739 {
//    public int[] dailyTemperature(int[] T){
//        Stack<Integer> stack = new Stack<>();
//        int[] res = new int[T.length];
//        for (int i = 0; i < T.length; i++){
//            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
//                int preIndex = stack.pop();
//                res[preIndex] = i - preIndex;
//            }
//            stack.push(i);
//        }
//        return res;
//    }
//}

/*
* 综上，这道求后面第一个比当前元素大的元素索引间距的题，共有三种思路
* 1、最简单最耗时的是双重循环，无非就是暴力求解啦
* 2、最快速但是也比较难想到的就是，找规律，从数组最后面开始进行遍历
*   这本质上是一种动态规划的思想；很值得学习
* 3、灵活应用了栈的数据结构的思想，就是 单调栈，用栈来维护数组元素大小关系
* */

public class Solution_739 {
    public int[] dailyTemperatures(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++){
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}

// 综上，最好的还是找规律、基于动态规划的；NB！
































