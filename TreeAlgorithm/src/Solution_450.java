/*
* 关于这道450删除二叉搜索树中的叶节点；
* 因为要进行删除，所以需要知道被删除节点的父节点；
* 所以我考虑的是，先对树进行一次遍历
* 遍历过程中，用一个HashMap来保存每个节点的父节点；
* 这样第二次遍历时，遇到了待删除节点，就可以直接获取其父节点；
*
* 当然，这是通过HashMap获取父节点的方式，理论上肯定可以在每次遍历时临时保存父节点；
* */


/*
* 5.10记录
* 麻了。。。本来代码都快写出来了；
* 才发现一个逻辑错误。。。
* 当然是可以先对树进行一次DFS遍历，用HashMap来保存每个节点的父节点；
* 但是呢，这里因为我们要删除节点，所以我们光知道父节点没用
* 还需要知道被删除节点是父节点的左孩子还是右孩子；不然连不起来；
* 当然是可以解决的，但是呢，这道题其实不用递归记录父节点也很好做；
* */

/*
* 5.11记录
* 1、麻了，改了好几次，最后发现记录父节点的方法在这里并不是很好用。。。
* 最大的一个问题就是，根节点的父节点如何记录呢？根节点的父节点不太好处理啊。。。
* 所以之前之所以好用HashMap对父节点进行记录，一直没考虑到是因为那道题不需要考虑
* 根节点的特殊情况。。。
* 2、其实从宏观上看，自己的思路是可行的，就是通过对树进行两次遍历；
* 第一次遍历记录父节点；第二次遍历进行查找删除；
* 3、还有就是，通过这次，发现自己思维还是不够严谨啊。。几个边界情况都没考虑到。。
* 4、然后就是，通过DFS记录父节点的代码写得不够好，虽然是差不多吧，但是就只是凑合；
* */

//import java.util.HashMap;
//import java.util.Stack;
//
//public class Solution_450 {
//
//    HashMap<TreeNode, TreeNode> parents = new HashMap<>();
//
//    public void DFS(TreeNode root, TreeNode parent){
//        if (root == null)
//            return;
//        parents.put(root, parent);
//        DFS(root.left, root);
//        DFS(root.right, root);
//    }
//
//    /*
//    * 之前这里的代码确实存在一个逻辑漏洞。。。
//    * 就是如果这棵树只有一个节点，那么这种方法就会有问题。。。
//    * 还有一种边界情况之前没考虑到，就是叶子结点的删除；。。
//    *
//    * */
//
//    public TreeNode deleteNode(TreeNode root, int key){
//        if (root==null)
//            return null;
//        if (root.left==null && root.right==null){
//            if (root.val == key)
//                return null;
//            else
//                return root;
//        }
//        DFS(root.left, root);
//        DFS(root.right, root);
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode cur = stack.pop();
//            if (cur.val == key){
//                TreeNode parent = parents.get(cur);
//                boolean flag= parent.left == cur;
//                if (cur.left!=null&&cur.right!=null){
//                    if (flag)
//                        parent.left = cur.right;
//                    else
//                        parent.right = cur.right;
//                    TreeNode temp = cur.right;
//                    while (temp.left!=null){
//                        temp = temp.left;
//                    }
//                    temp.left=cur.left;
//                }else if (cur.left!=null){
//                    if (flag)
//                        parent.left = cur.left;
//                    else
//                        parent.right = cur.left;
//                }else if (cur.right!=null){
//                    if (flag)
//                        parent.left = cur.right;
//                    else
//                        parent.right = cur.right;
//                }else {
//                    if (flag)
//                        parent.left = null;
//                    else
//                        parent.right = null;
//                }
//            }
//            if(cur.right!=null)
//                stack.push(cur.right);
//            if (cur.left!=null)
//                stack.push(cur.left);
//        }
//        return root;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 450!");
//    }
//}


/*
* 5.11记录
* ！！刚刚重写自己想法时，突然发现，其实只需要遍历一次啊。傻了
* 之前的HashMap是设置为<TreeNode, TreeNode>，但其实不需要这样的。。
* 可以直接设置为<Integer, TreeNode>，这样不就方便多了。
* 直接能够获取到对应key的父节点，这样就可以直接进行删除了啊！
* 也就避免了第二次遍历时需要处理的一些麻烦问题！！
* 可以尝试尝试！
* */

//import java.util.HashMap;
//
//public class Solution_450 {
//
//    HashMap<Integer,TreeNode> parents = new HashMap<>();
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
//    public TreeNode deleteNode(TreeNode root, int key){
//        if (root==null)
//            return null;
//        if (root.val == key){
//            if (root.left!=null && root.right!=null){
//                TreeNode temp = root.right;
//                while (temp.left!=null)
//                    temp = temp.left;
//                temp.left = root.left;
//                return root.right;
//            }else if (root.left!=null){
//                return root.left;
//            }else if (root.right!=null){
//                return root.right;
//            }else{
//                return null;
//            }
//        }
//        DFS(root);
//        TreeNode parent = parents.get(key);
//        TreeNode cur = new TreeNode(0);
//        boolean flag = true;
//        if (parent.left.val == key) {
//            cur = parent.left;
//        }
//        else {
//            cur = parent.right;
//            flag = false;
//        }
//        if (cur.left!=null && cur.right!=null){
//            TreeNode temp = cur.right;
//            if (flag)
//                parent.left = cur.right;
//            else
//                parent.right = cur.right;
//            while (temp.left!=null)
//                temp = temp.left;
//            temp.left = cur.left;
//        } else if (cur.left!=null){
//            if (flag)
//                parent.left = cur.left;
//            else
//                parent.right = cur.left;
//        }else if (cur.right!=null){
//            if (flag)
//                parent.left = cur.right;
//            else
//                parent.right = cur.right;
//        }else {
//            if (flag)
//                parent.left = null;
//            else
//                parent.right = null;
//        }
//        return root;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 450!");
//    }
//}
//

/*
* 下面是直接递归实现。写起来高级很多！！！要掌握啊！！！
* */

/*
* 这里删除树的节点，并不需要知道被删除节点的父节点！！！
* 因为删除一个节点可以从两个层面去考虑，一个是节点层面的删除、一个是value层面的删除
* 我们其实需要的是value层面的删除，虽然节点层面的删除当然是可以做到的，但是不够精确
* 而且这里递归的写法真的需要掌握！！！
* */

//public class Solution_450 {
//
//    public TreeNode deleteNode(TreeNode root, int key){
//        if (root == null)
//            return null;
//        if (key < root.val)
//            root.left = deleteNode(root.left, key);
//        else if (key > root.val)
//            root.right = deleteNode(root.right, key);
//        else {
//            // case 1:
//            if (root.right!=null && root.left!=null){
//                TreeNode pre = root;
//                TreeNode next = pre.right;
//                while (next.left!=null){
//                    pre = next;
//                    next = next.left;
//                }
//                if (pre == root)
//                    pre.right = next.right;
//                else
//                    pre.left = next.right;
//                root.val = next.val;
//            }else if (root.left == null){
//                return root.right;
//            }else {
//                return root.left;
//            }
//        }
//        return root;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}


public class Solution_450 {
    public TreeNode deleteNode(TreeNode root, int key){
        if (root == null)
            return null;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.right!=null && root.left!=null){
                TreeNode pre = root;
                TreeNode next = root.right;
                while (next.left!=null){
                    pre = next;
                    next = next.left;
                }
                /*
                * 这里唯一需要注意的就是
                * 如果被删除节点，左子树和右子树都有节点
                * 那么就需要找到右子树里面那个被替换节点
                * 也就是右子树的最左节点，将其与root替换
                * 但是，同时还需要处理这个最左节点，将它删除，因为它移上去了！
                * */
                if (pre == root)
                    pre.right = next.right;
                else
                    pre.left = next.right;
                root.val = next.val;
            }else if (root.left!=null)
                return root.left;
            else
                return root.right;
        }
        return root;
    }
}






























