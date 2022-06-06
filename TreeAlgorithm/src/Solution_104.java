/*
* 求树的最大深度，赤裸裸的递归题，直接写；
* */

public class Solution_104 {

    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r) + 1;
    }

    public static void main(String[] args) {

    }
}
