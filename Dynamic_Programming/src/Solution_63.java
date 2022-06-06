
/*
* 这是道路径条数题的变形题；
* 在二维矩阵中设置某些节点为障碍，不可访问；
* 但其实动态规划本身没有变化；
* */

public class Solution_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++){
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++){
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (obstacleGrid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
