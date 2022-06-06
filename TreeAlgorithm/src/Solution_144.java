//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution_144 {
//
//    public List<Integer> ans = new ArrayList<Integer>();
//    public void preOrder(TreeNode root){
//        if (root == null)
//            return;
//        ans.add(root.val);
//        preOrder(root.left);
//        preOrder(root.right);
//    }
//
//    public List<Integer> preorderTraversal(TreeNode root){
//        preOrder(root);
//        return ans;
//    }
//}

//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution_144 {
//
//    List<Integer> ans = new ArrayList<>();
//
//    void preorder(TreeNode root){
//        if (root == null)
//            return;
//        ans.add(root.val);
//        preorder(root.left);
//        preorder(root.right);
//    }
//
//    public List<Integer> preorderTraversal(TreeNode root){
//        preorder(root);
//        return ans;
//    }
//}

// 下面是非递归写法，自己写一个栈来实现；

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_144 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root){
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            // 下面是手动将子节点进行压栈的操作
            // 和我们正常逻辑相反，手动压栈，应该先将右节点压入再将左节点压入；
            if (cur.right!=null)
                stack.push(cur.right);
            if (cur.left!=null)
                stack.push(cur.left);
        }
        return ans;
    }
}










