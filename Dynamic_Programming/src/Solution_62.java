
/*
* 这道题，涉及到二维数组中的个数统计；脑海中一下子就闪过，DFS and DP；
* 必然用深度搜索是可以做的，如果时间允许，没什么是暴力穷举解决不了的。。
* However，这道题显然是为了考察动态规划，那么用DFS必然会超时；
* 下面是用DFS实现的方法；没通过；
* */

//public class Solution_62 {
//
//    public int DFS(int i, int j, int m, int n){
//        if (i == m && j == n)
//            return 1;
//        if (i > m || j > n)
//            return 0;
//        return DFS(i+1, j, m, n) + DFS(i, j+1, m, n);
//    }
//
//    public int uniquePaths(int m, int n){
//        // 这里的开始节点和结束节点，0,0或者1,1都没事，终点要相应变化就行
////        return DFS(0, 0, m-1, n-1);
//        return DFS(1, 1, m, n);
//    }
//
//}

/*
* 这道题，求一个二维矩阵中路径条数；
* 这种求路径总数目，求总数目的题，显然采用动态规划处理；
* 而且显然dp数组应该是一个二维数组；dp[m][n]；
* 唯一不同的在于，这里的初始化方式需要注意；
* 第一行和第一列上的每一个位置都是只有一条路径可达；
* 状态转移方程也非常简单：
* dp[i][j] = dp[i-1][j] + dp[i][j-1];
* */

//public class Solution_62 {
//
//    public int uniquePaths(int m, int n){
//        int[][] dp = new int[m][n];
//        dp[0][0] = 0;
//        for (int i = 0; i < m; i++)
//            dp[0][i] = 1;
//        for (int j = 0; j < n; j++)
//            dp[j][0] = 1;
//
//        for (int i = 1; i < m; i++)
//            for (int j = 1; j < n; j++)
//                dp[i][j] = dp[i-1][j] + dp[i][j-1];
//        return dp[m-1][n-1];
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 62!");
//    }
//}

/*
* 上面那种初始化方式单独初始化，略微浪费时间；
* 下面可以将这两个初始化整合在一块
* */

public class Solution_62 {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
        return dp[m-1][n-1];
    }
}


