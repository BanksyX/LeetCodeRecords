
/*
* 这道题，整数拆分，其实也想得到是动态规划；
* 不过这种题最好还是要在草稿纸上写一下最初的几个推导过程；
* 1、状态转移方程：
* dp[i] = max(dp[i], dp[j]*dp[i-j]);
* 也就是将之前拆分结果的最大值dp[i]和
* 当前可以拆分的一个方案的结果(dp[j]*dp[i-j])进行比较更新最大值
* dp[j]*dp[i-j] 其中j代表从第j个数开始拆分，i-j是剩下部分；
* 而dp[j]和dp[i-j]都是之前已经记录过的；
*
* 2、初始化，这里的初始化有点小技巧；
* dp[1] = 1; dp[2] = 2; dp[3] = 3;
* 这并不是说 n = 1, 2, 3就应该返回这个；这里的三个值仅用于后面的更新；
* dp[1]是指为1时我们不拆分最大值为1，dp[2]即n为2时我们不拆分使最大值为2；dp[3]也是
* 即拆分到n=1,2,3时我们就不需要再往下拆了，因为再拆就会变小，我们是求最大值，所以不拆了
*
* 3、循环
* 因为dp[] 1,2,3存储的并不是真实值；
* 所以我们要对真实的1 2 3进行额外判断并返回；
* 从而下面的i遍历从4开始
* j从1即第一个数拆分开始，然后j结束于i/2，因为只需要拆一半，后一半都一样
* */

//public class Solution_343 {
//
//    public int integerBreak(int n){
//        if (n < 2)
//            return 1;
//        if (n == 2)
//            return 1;
//        if (n == 3)
//            return 2;
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 3;
//        for (int i = 4; i <= n; i++){
//            for (int j = 1; j <= (i/2); j++){
//                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
//            }
//        }
//        return dp[n];
//    }
//
//}


//public class Solution_343 {
//
//    public int integerBreak(int n){
//        if (n < 2)
//            return 1;
//        if (n == 2)
//            return 1;
//        if (n == 3)
//            return 2;
//        int[] dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 3;
//        for (int i = 4; i <= n; i++)
//            for (int j = 1; j <= (i/2); j++)
//                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
//        return dp[n];
//    }
//}




/*
* 上面这种解法的思路是一种，唯一容易弄错的就是初始化；
* 因为本质上dp[1]是没意义的，而且dp[2] dp[3]的初始化稍微有点不好理解
* 下面这种解法，初始化就非常好理解，就只有dp[2] = 1;这是正常的；
* 而且最开始不需要进行额外判断
* */

public class Solution_343 {
    public int integerBreak(int n){
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j <= (i-j); j++)
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
        return dp[n];
    }
}


/*
* 代码看起来更为简洁；
* 其中dp[i] 表示正整数i拆分后的结果最大乘积；
* 代码中不会管dp[0] dp[1]因为这本身就是没意义的；
* j*(i-j)就是把整数i拆分成两个数，即 j和(i-j)，然后再相乘，也就是之拆分成两个数
* j*dp[i-j]就是将i拆分成两个及两个以上的个数，再相乘；
* */

















