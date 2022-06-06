import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 这里想到了一个可以优化的部分，我们其实可以对数组进行排序，
* 按照递增序排列，这样如果我们遇到了加和大于target的，那么之后的就不需要尝试了
* */

//public class Solution_39 {
//
//    public List<List<Integer>> res = new ArrayList<>();
//    public List<Integer> list = new ArrayList<>();
//
//    public void DFS(int sum, int[] candidates, int target){
//        if (sum > target)
//            return;
//        if (sum == target){
//            res.add(new ArrayList<Integer>(list));
//            return;
//        }
//        for (int i = 0; i < candidates.length; i++){
////            if ((sum+candidates[i])>target)
////                continue;
//            list.add(candidates[i]);
//            DFS(sum+candidates[i], candidates, target);
//            list.remove(list.size()-1);
//        }
//    }
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target){
//        DFS(0, candidates, target);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 39!");
//    }
//}


//public class Solution_39 {
//
//    public List<List<Integer>> res = new ArrayList<>();
//    public List<Integer> list = new ArrayList<>();
//
//    public void DFS(int sum, int[] candidates, int target, int startIndex){
//        if (sum == target){
//            res.add(new ArrayList<Integer>(list));
//            return;
//        }
//        for (int i = startIndex; i < candidates.length; i++){
//            if ((sum+candidates[i])>target)
//                continue;
//            list.add(candidates[i]);
//            DFS(sum+candidates[i], candidates, target, i);
//            list.remove(list.size()-1);
//        }
//    }
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target){
//        DFS(0, candidates, target, 0);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 39!");
//    }
//}

/*
* 下面是加入sort对原数组进行排序，看能不能起到优化的作用，就相当于剪枝
* 。。。经过测试吧，能通过测试，但是发现对性能提升不大。。。
* 不是很清楚Java这个Array.sort是怎么实现，理论上加了这个应是可以提升部分性能的。
* */

public class Solution_39 {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();

    public void DFS(int sum, int[] candidates, int target, int startIndex){
        if (sum == target){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++){
            if ((sum+candidates[i])>target)
                break;
            list.add(candidates[i]);
            DFS(sum+candidates[i], candidates, target, i);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        DFS(0, candidates, target, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello, 39!");
    }
}




