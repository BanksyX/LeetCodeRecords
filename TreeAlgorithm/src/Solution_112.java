/*
* 112 单纯只需要判断是否存在路径总和相等的情况；
* 所以相对是比较简单的，主要可以通过 递归和迭代搜索两种方法实现；
* 其中，递归，写法很好看，也很简单，只是写的时候要好好组织代码；
* 搜索，可以考虑DFS深搜或者BFS广搜；
* 虽然说，树的遍历本身应该也可以完成这种任务，但似乎没那么容易实现；
* 以后，对于树的遍历，还是尽量考虑 DFS 或者 BFS
* */

//public class Solution_112 {
//
//    public boolean hasPathSum(TreeNode root, int sum){
//        if (root == null)
//            return false;
//        if (root.left == null && root.right == null)
//            return sum == root.val;
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }
//
//    public static void main(String[] args) {
//
//    }
//}

import java.util.LinkedList;
import java.util.Queue;

public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum){
        if (root == null)
            return false;
        Queue<Integer> queVal = new LinkedList<Integer>();
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        queNode.add(root);
        queVal.add(root.val);
        while (!queNode.isEmpty()){
            TreeNode cur = queNode.poll();
            int temp = queVal.poll();
            if (cur.left == null && cur.right == null){
                if (temp == sum)
                    return true;
            }
            if (cur.left!=null){
                queNode.add(cur.left);
                queVal.add(cur.left.val + temp);
            }
            if (cur.right!=null){
                queNode.add(cur.right);
                queVal.add(cur.right.val + temp);
            }
        }
        return false;
    }
}









