/*
* 297 将一棵二叉树序列化和反序列化；
* 虽然是一道Hard题，但是本质上就是对树进行遍历并保存；
* 然后从遍历结果中重建树；
* 既然是遍历，那么自然就可以考虑 DFS、BFS这些了；
* 此外，还可以考虑层序遍历；
* 不过值得注意的是，DFS和先序、中序、后序的关系；
* DFS是一种深度遍历方式，可以分为上面三种方式，其中最常用的当然是先序方式；
* */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//public class Solution_297 {
//
//    public String implementSerialize(TreeNode root, String str){
//        if (root==null){
//            str+="None";
//        }else {
//            str += String.valueOf(root.val) + ",";
//            str = implementSerialize(root.left, str);
//            str = implementSerialize(root.right, str);
//        }
//        return str;
//    }
//
//    public String serialize(TreeNode root){
//        return implementSerialize(root, "");
//    }
//
//    public TreeNode implementDeserialize(List<String> dataString){
//        if (dataString.get(0).equals("None")){
//            dataString.remove(0);
//            return null;
//        }
////        TreeNode root = new TreeNode(Integer.valueOf(dataString.get(0)));
//        TreeNode root = new TreeNode(Integer.parseInt(dataString.get(0)));
//        dataString.remove(0);
//        root.left = implementDeserialize(dataString);
//        root.right = implementDeserialize(dataString);
//        return root;
//    }
//
//    public TreeNode deserialize(String data){
//        String[] dataArray = data.split(",");
//        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
//        return implementDeserialize(dataList);
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 297!");
//    }
//}

//public class Solution_297 {
//
//    public String serialize(TreeNode root){
//        return implementSerialize(root, "");
//    }
//
//    public TreeNode deserialize(String data){
//        String[] dataArray = data.split(",");
//        List<String> inputList = new LinkedList<String>(Arrays.asList(dataArray));
//        return implementDeserialize(inputList);
//    }
//
//    public String implementSerialize(TreeNode root, String str){
//        if (root == null){
//            str += "None,";
//        }else {
//            str += String.valueOf(root.val) + ",";
//            str = implementSerialize(root.left, str);
//            str = implementSerialize(root.right, str);
//        }
//        return str;
//    }
//
//    public TreeNode implementDeserialize(List<String> dataList){
//        if (dataList.get(0).equals("None")){
//            dataList.remove(0);
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
//        root.left = implementDeserialize(dataList);
//        root.right = implementDeserialize(dataList);
//        return root;
//    }
//}

/*
* 下面这就是 利用DFS先序遍历来实现的；还算比较好写和理解
* */

//public class Solution_297 {
//    public String serialize(TreeNode root) {
//        return rserialize(root, "");
//    }
//
//    public TreeNode deserialize(String data) {
//        String[] dataArray = data.split(",");
//        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
//        return rdeserialize(dataList);
//    }
//
//    public String rserialize(TreeNode root, String str) {
//        if (root == null) {
//            str += "None,";
//        } else {
//            str += String.valueOf(root.val) + ",";
//            str = rserialize(root.left, str);
//            str = rserialize(root.right, str);
//        }
//        return str;
//    }
//
//    public TreeNode rdeserialize(List<String> dataList) {
//        if (dataList.get(0).equals("None")) {
//            dataList.remove(0);
//            return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
//        dataList.remove(0);
//        root.left = rdeserialize(dataList);
//        root.right = rdeserialize(dataList);
//
//        return root;
//    }
//}


/*
* 下面我们再使用 层序遍历 实现一次
* */

//public class Solution_297 {
//
//    public String serialize(TreeNode root){
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        StringBuilder builder = new StringBuilder();
//
//        while (!queue.isEmpty()){
//            TreeNode temp = queue.poll();
//            if (temp == null){
//                builder.append("None").append(",");
//            }
//            builder.append(temp.val).append(",");
//            queue.add(temp.left);
//            queue.add(temp.right);
//        }
//        return builder.toString();
//
//    }
//
//    public TreeNode deserialize(String data){
//        Queue<TreeNode> queue = new LinkedList<>();
//        String[] nodes = data.split(",");
//        if ("None".equals(nodes[0])){
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//        queue.add(root);
//        for (int i = 1; i < nodes.length;){
//            TreeNode node = queue.poll();
//            String left = nodes[i++];
//            if (!"None".equals(left)){
//                node.left = new TreeNode(Integer.parseInt(left));
//                queue.add(node.left);
//            }
//            String right = nodes[i++];
//            if (!"None".equals(right)){
//                node.right = new TreeNode(Integer.parseInt(right));
//                queue.add(node.right);
//            }
//        }
//        return root;
//    }
//}


/*
* 根据LeetCode测评显示，层序遍历进行序列化和反序列化时间是最快的，空间消耗也较小
* */

public class Solution_297 {
    String NULL = "#";
    String SEP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //层序遍历BFS的模板
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                builder.append(NULL).append(SEP);
                continue;
            }
            builder.append(node.val).append(SEP);
            queue.add(node.left);
            queue.add(node.right);
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList();
        String[] nodes = data.split(SEP);
        if(NULL.equals(nodes[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        //[1,    2,3,  4,5,6,7]
        //[第一层|第二层|第三层]
        //通过索引控制队列中的父节点的子节点
        //例如根节点为root，索引为0，其子节点索引为1和2 于是从索引值为1的结点开始遍历
        for(int i=1;i<nodes.length;) {
            TreeNode node = queue.poll();
            String left = nodes[i++];
            if(!NULL.equals(left)) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.add(node.left);
            }
            String right = nodes[i++];
            if(!NULL.equals(right)) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.add(node.right);
            }
        }
        return root;
    }
}

















