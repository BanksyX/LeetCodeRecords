/*
* 这道题，计算完全二叉树的节点个数？？
* 计算树的节点总数时，完全二叉树和其他树有区别吗？？
* 直接DFS递归一下秒过；
* */

//public class Solution_222 {
//
//    public int counts = 0;
//
//    void DFS(TreeNode root){
//        if (root==null)
//            return;
//        counts+=1;
//        DFS(root.left);
//        DFS(root.right);
//    }
//
//    public int countNodes(TreeNode root){
//        DFS(root);
//        return counts;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}

//
//public class Solution_222 {
//
//    void DFS(TreeNode root, int nums){
//        if (root == null)
//            return;
//        DFS(root.left, nums+=1);
//        DFS(root.right, nums+=1);
//    }
//
//    public int countNodes(TreeNode root){
//        int counts = 0;
//        DFS(root, counts);
//        return counts;
//    }
//}





