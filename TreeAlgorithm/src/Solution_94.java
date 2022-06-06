//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution_94 {
//
//    List<Integer> ans = new ArrayList<>();
//
//    void inOrder(TreeNode root){
//        if (root == null)
//            return;
//        inOrder(root.left);
//        ans.add(root.val);
//        inOrder(root.right);
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root){
//        inOrder(root);
//        return ans;
//    }
//}


// 中序遍历非递归实现

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class Solution_94 {
//    public List<Integer> inorderTraversal(TreeNode root){
//        List<Integer> ans = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root!=null || !stack.isEmpty()){
//            while (root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            if (!stack.isEmpty()){
//                root = stack.pop();
//                ans.add(root.val);
//                root = root.right;
//            }
//        }
//        return ans;
//    }
//}

// 中序遍历的非递归实现
// 实现过程和先序遍历不同，因为是左根右
// 所以是尽可能的将所有左子树全部先入栈，一直到左子树为空，才将根节点弹出
// 弹出以后便是 根了，然后可以进行相关操作，然后遍历到根的右子树；继续上面的判断

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
















