import java.util.ArrayList;
import java.util.List;

/*
* 这道题全排列回溯题，一遍过hiahia
* 其实很简单啦，就是回溯模板题了；
* 不过唯一受不了的就是，写了一段时间C代码，再写Java代码，实在觉得Java有些地方太挥霍了
* 这里nums数组因为不是全局的，而DFS又要获取，但还真不好处理
* 就只能将nums作为DFS的参数作为输入......目前没想到好的处理方法
* 但即使这样，这道题的性能居然在Java提交中也很不错......绝了
* 此外还要注意一个地方就是；
*
* 这里面常见的二维数组声明是:
* List<List<Integer>> list = new ArrayList<>();
* 一维数组声明是 List<Integer> list = new ArrayList<>();
* 如果要 list.add(list)
* 那么不能直接add，要这样 list.add(new ArrayList<Integer>(list));才行；
* */
//
//public class Solution_46 {
//
//    List<List<Integer>> resList= new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
//
//    void DFS(int level, int[] nums){
//        if (level == nums.length){
////            resList.add(list);
//            resList.add(new ArrayList<Integer>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++){
//            if (list.contains(nums[i]))
//                continue;
//            list.add(nums[i]);
//            DFS(level+1, nums);
//            list.remove(list.size()-1);
//        }
//    }
//
//    public List<List<Integer>> permute(int[] nums){
//        int height = nums.length;
//        DFS(0, nums);
//        return resList;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println("Hello, World!");
//    }
//}


public class Solution_46 {

    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    void DFS(int level, int[] nums){
        if (level == nums.length){
            resList.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            DFS(level+1, nums);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums){
        DFS(0, nums);
        return resList;
    }
}
























