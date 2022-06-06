
/*
* 这道题是求给定节点数目的情况下，可以生成的子树的个数；
* 其实可以看出，是可以进行子问题分解的；即肯定可以使用动态规划；
* 但是这里的状态转移方程，有点难以考虑到，以前的状态转移方程都是加法操作；
* 这里是乘积（笛卡尔积）；
* 但其实题目还是很简单的；
*
* */

//public class Solution_96 {
//
//    public int numTrees(int n){
//        int[] dp = new int[n+1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++)
//            for (int j = 1; j <= i; j++)
//                dp[i] += dp[j-1]*dp[i-j];
//        return dp[n];
//    }
//}


public class Solution_96 {
    public int numTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i] += (dp[j-1] * dp[i-j]);
        return dp[n];
    }
}


