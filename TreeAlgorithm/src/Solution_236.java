/*
* 树上的最近公共祖先；
* 用DFS实现；
* 递归实现；
* */

/*
* 下面这种方法就是通过递归实现的，算是实现起来最简单的一种方法了；
* */
//
//public class Solution_236 {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        if (root == null || p == null || q == null)
//            return null;
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left == null && right == null)
//            return null;
//        if (left == null)
//            return right;
//        if (right == null)
//            return left;
//        return root;
//    }
//}


/*
* 236还有另外一种实现思路，即保存父节点，然后对两个待查询节点的父节点进行对比
* 找到第一个相等的节点即返回；
* 但是这种思路具体实现又可以分为两种实现；
* 1、利用HashSet来保存DFS过程中遇到的父节点；
* 2、利用栈来存储待查寻节点的全部父节点；
* 本质思路上都是一样的，保存父节点然后逐个对比；
* 但是不同在于用不同的数据结构进行实现；
* */

/*
* 用HashSet保存父节点的实现
* */
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Solution_236 {
//
//    HashMap<Integer, TreeNode> parent = new HashMap<>();
//    Set<Integer> set = new HashSet<>();
//
//    public void DFS(TreeNode root){
//        if (root.left!=null){
//            parent.put(root.left.val, root);
//            DFS(root.left);
//        }
//        if (root.right!=null){
//            parent.put(root.right.val, root);
//            DFS(root.right);
//        }
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        DFS(root);
//        while (p!=null){
//            set.add(p.val);
//            p = parent.get(p.val);
//        }
//        while (q!=null){
//            if (set.contains(q.val)){
//                return q;
//            }
//            q = parent.get(q.val);
//        }
//        return null;
//    }
//}
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Solution_236 {
//    HashMap<Integer, TreeNode> parents = new HashMap<>();
//    Set<Integer> set = new HashSet<>();
//
//    public void DFS(TreeNode root){
//        if (root.left!=null){
//            parents.put(root.left.val, root);
//            DFS(root.left);
//        }
//        if (root.right!=null){
//            parents.put(root.right.val, root);
//            DFS(root.right);
//        }
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        DFS(root);
//        while (p!=null){
//            set.add(p.val);
//            p = parents.get(p.val);
//        }
//        while (q!=null){
//            if (set.contains(q.val)){
//                return q;
//            }
//            q = parents.get(q.val);
//        }
//        return null;
//    }
//}

/*
* 接下里是用栈来实现所有父节点的保存；
* 上面的HashMap保存理论上比栈保存要更加高效
* 因为HashMap保存是存储的全局映射，即对所有节点的父节点只存储一份拷贝。
* 但是呢，HashMap存在的一个问题在于，因为我们其实只需要两个节点的父节点集合；
* 但是HashMap中因为DFS遍历整棵树的缘故，所以所有节点的父节点都进行了保存；
* 不过空间开销其实好好，也就O(n)
* 这种用HashMap存储父节点的方式有点类似，并查集中的父节点查询方式
*
* 然后用栈保存的话，必然需要两个栈，分别用来存储两个节点的父节点链路；
* */

import java.util.Stack;

public class Solution_236 {

    public boolean DFS(TreeNode root, TreeNode searchNode, Stack<TreeNode> stack){
        if (root == null || stack == null)
            return false;
        stack.push(root);
        if (root == searchNode){
            return true;
        }
        boolean flag = DFS(root.left, searchNode, stack);
        if (flag)
            return true;
        flag = DFS(root.right, searchNode, stack);
        if (flag)
            return true;
        stack.pop();
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return null;
        Stack<TreeNode> stack1 = new Stack<>();
        DFS(root, p, stack1);
        Stack<TreeNode> stack2 = new Stack<>();
        DFS(root, q, stack2);
        int size1 = stack1.size();
        int size2 = stack2.size();
        if (size1-size2>0){
            int inter = size1 - size2;
            while (inter-->0){
                stack1.pop();
            }
            while (!stack1.isEmpty() && !stack2.isEmpty()){
                if (stack1.peek() == stack2.peek()){
                    return stack1.peek();
                }else {
                    stack1.pop();
                    stack2.pop();
                }
            }
        }else {
            int inter = size2 - size1;
            while (inter-- > 0)
                stack2.pop();
            while (!stack1.isEmpty() && !stack2.isEmpty()){
                if (stack1.peek() == stack2.peek()){
                    return stack2.peek();
                }else {
                    stack1.pop();
                    stack2.pop();
                }
            }
        }
        return null;
    }
}









































