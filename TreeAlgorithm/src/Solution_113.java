/*
* 这道题求树中的路径和，是基于树的遍历展开的，感觉可以试试中序遍历
* */
//
//import java.util.*;
//
//public class Solution_113 {
//
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
//        if (root==null)
//            return new ArrayList<>();
//        int res = 0;
//        List<List<Integer>> ansList = new LinkedList<List<Integer>>();
//
//        // 下面是中序遍历非递归实现
//        Stack<TreeNode> stack = new Stack<>();
//        while (root!=null || !stack.isEmpty()){
//
//            Deque<Integer> queue = new LinkedList<>();
//
//            while (root!=null){
//                stack.push(root);
//                res+=root.val;
//                queue.addLast(root.val);
//                root = root.left;
//            }
//            if (res == targetSum){
////                ansList.add(new LinkedList<Integer>(queue));
//
//            }
//            if (!stack.isEmpty()){
//                root = stack.pop();
//                // 这里写相关操作；
//                res-=root.val;
//                queue.pollLast();
//                root = root.right;
//            }
//        }
//        return ansList;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}



// 最开始打算这道题用中序遍历来实现的。。
// 但是代码写的不好。。。理论上是可以用中序遍历做到的，但是自己没写出来。。。
// 这道题用DFS写应该更好写。。


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_113 {

    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<>();

    public void DFS(TreeNode root, int sum){
        if (root == null)
            return;
        path.offerLast(root.val);
        sum-=root.val;
        if (root.left==null && root.right==null && sum==0)
            res.add(new LinkedList<Integer>(path));
        DFS(root.left, sum);
        DFS(root.right, sum);
        path.pollLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        DFS(root, targetSum);
        return res;
    }

    public static void main(String[] args) {

    }
}





















