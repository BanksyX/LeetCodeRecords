
/*
* 爬楼梯问题，也是最简单的动态规划问题，当然也可以用递归来实现；
* 而且思想都很简单，感觉和斐波那契数列差不多
* */

/*
* 下面先用简单的递归进行了实现；
* 然后发现，有些例程超时了。。。？
* 做了个测试，n=45时，计算确实已经很慢了。。。
* */

//public class Solution_70 {
//
//    public int climbStairs(int n){
//        if (n <= 2)
//            return n;
//        return climbStairs(n-1) + climbStairs(n-2);
//    }
//
//    public static void main(String[] args) {
//        Solution_70 s = new Solution_70();
//        int res = s.climbStairs(45);
//        System.out.println("Hello, 70!");
//        System.out.println(res);
//    }
//}


/*
* 下面是用动态规划写的，直接过了，没被卡； time:100% Memory:88%
* */

public class Solution_70 {
    public int climbStairs(int n){
        if (n <= 2)
            return n;
        int a = 1, b = 2, c = 0;
        for (int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

