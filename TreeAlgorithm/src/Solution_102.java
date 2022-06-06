//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class Solution_102 {
//
//    public List<List<Integer>> levelOrder(TreeNode root){
//        if (root == null)
//            return new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int count = queue.size();
//            List<Integer> list = new ArrayList<>();
//            while (count-- > 0){
//                TreeNode cur = queue.poll();
//                list.add(cur.val);
//                if (cur.left!=null)
//                    queue.add(cur.left);
//                if (cur.right!=null)
//                    queue.add(cur.right);
//            }
//            res.add(list);
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 层序遍历的实现，用队列即可；
public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        if (root==null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left!=null)
                    queue.add(cur.left);
                if (cur.right!=null)
                    queue.add(cur.right);
            }
            res.add(list);
        }
        return res;
    }
}





















