/*
* 斐波那契数列，最基础的动态规划系列了
* 要用一个一维数组来保存递推结果；
* 1、明确dp数组下表含义，dp[i]:第i个数的斐波那契数值为dp[i]
* 2、递推公式: dp[i] = dp[i-1] + dp[i-2]
* 3、dp数组初始化 dp[0] = 0, dp[1] = 1;
* 4、遍历顺序，从递推公式可以看出，dp[i]依赖于dp[i-1]和dp[i-2]，
* 所以遍历顺序是从前向后遍历；
* 5、其实不需要维护一个一维数组，我们如果只需要获取dp[n]数值，
* 那么只需要保存dp[n-1]和dp[n-2]两个数值即可；所以只需要维护两个数值；
* */



//public class Solution_509 {
//
//    public int fib(int n){
//        if (n < 2)
//            return n;
//        int a = 0, b = 1, c = 0;
//        for (int i = 0; i < n; i++){
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return c;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 509!");
//    }
//}

//
//public class Solution_509 {
//    public int fib(int n){
//        if (n < 2)
//            return n;
//        int a = 0, b = 1, c = 0;
//        for (int i = 1; i < n; i++){
//            c = a + b;
//            a = b;
//            b = c;
//        }
//        return c;
//    }
//}

/*
* 下面可以试试递归的写法；递归写法非常简洁；
* 递归的写法虽然简洁，但是相比递推，较为复杂和耗时；
* */

public class Solution_509 {
    public int fib(int n){
        if (n < 2)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}






