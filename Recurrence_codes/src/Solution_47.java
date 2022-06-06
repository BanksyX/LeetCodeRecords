
/*
* 之前那个全排列题是不包含重复数字的，这道题是包含重复数字的。。
* 这类算法题的一个铁律就是，如果出现了包含重复数字的情况；
* 那么一定要考虑排序的trick；
* 特别是存储在列表中的情况，那么一定可以考虑对列表进行排序
* 因为这就将 所有重复的元素连续排在一起了，这样就方便我们对重复情况进行处理
* 比如回溯中的剪枝，比如利用vis[]数组判断是否已经访问；
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//
//public class Solution_47 {
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
//
//    public void DFS(int level, int[] nums){
//        if (level == nums.length){
//            res.add(new ArrayList<Integer>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++){
//            if (list.contains(nums[i]))
//                continue;
//            list.add(nums[i]);
//            DFS(level+1, nums);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    public List<List<Integer>> permuteUnique(int[] nums){
//        DFS(0, nums);
//        return res;
//    }
//}

public class Solution_47 {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();

    public void DFS(int[] nums, boolean[] used){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;

            if (!used[i]){
                used[i] = true;
                list.add(nums[i]);
                DFS(nums, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums){
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        DFS(nums, used);
        return res;
    }

}



