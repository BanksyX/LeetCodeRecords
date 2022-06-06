/*
* 关于这道爬楼梯的题，本身并不难吧，但是最开始意思有点难理解。。。
* 可以这么理解：
* 在首位都加上一个0，分别代表地面和楼顶；
* 数组的每一个数字代表从当前楼梯迈出步伐所需要耗费的体力；
* （所以是离开这个台阶所耗费的体力，而不是来到这个台阶所耗费的体力）
* 从地面开始，第一步可以选择第0阶或者第1阶，从地面开始这次不需要耗费体力；
* 一直到达最后一个0也就是楼顶，求耗费最少的体力；
* 所以dp[i]可以理解为从i楼离开所需要耗费的最少体力；
* dp[0] = cost[0], dp[1] = cost[1]也就好理解了；
* */

//public class Solution_74 {
//
//    public int minCostClimbingStairs(int[] cost){
//        if (cost == null || cost.length == 0)
//            return 0;
//        if (cost.length == 1)
//            return cost[0];
//        int[] dp = new int[cost.length];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for (int i = 2; i < cost.length; i++){
//            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
//        }
//        return Math.min(dp[cost.length-1], dp[cost.length-2]);
//    }
//}


//public class Solution_74 {
//
//    public int minCostClimbingStairs(int[] cost){
//        if (cost == null || cost.length == 0)
//            return 0;
//        if (cost.length == 1)
//            return cost[0];
//        int[] dp = new int[cost.length];
//        dp[0] = cost[0];
//        dp[1] = cost[1];
//        for (int i = 2; i < cost.length; i++)
//            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
//        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
//    }
//}


/*
* 当然也可以另外一个理解，爬第一步不花费体力，但是最后一步要花费体力；
* 其实这种写法最好理解；
* 最开始时不需要消耗体力，且可以随意选择从0或者1节开始
* 所以设置dp[0] = 0, dp[1] = 0；
* 然后递归关系式为 dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
* 也就是，当前第i节楼梯，是从前一节或者前两节中选择一个消耗最小的
* 然后从那层跳到这层需要的消耗数；
* 所以最后返回的就是dp[cost.length]
* */

//public class Solution_74 {
//    public int minCostClimbingStairs(int[] cost){
//        if (cost == null || cost.length == 0)
//            return 0;
//        if (cost.length == 1)
//            return cost[0];
//        int[] dp = new int[cost.length + 1];
//        // 到达第一节楼梯不需要花费体力，题目说最开始可以随意选0或者1阶开始；
//        dp[0] = 0;
//        dp[1] = 0;
//        for (int i = 2; i <= cost.length; i++)
//            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
//        return dp[cost.length];
//    }
//}




public class Solution_74 {
    public int minCostClimbingStairs(int[] cost){
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++)
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        return dp[cost.length];
    }
}



















