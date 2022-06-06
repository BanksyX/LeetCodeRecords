/*
* 关于这种求子集问题，不同于之前的求排列、求分割的问题；
* 1、子集问题是要求出树中所有的节点，即在遍历过程中，所有节点都要保存下来
* 不需要任何剪枝！
*
* 2、子集问题是一种组合问题，集合中元素是无序的
* 不同于排列问题中{1,2}和{2,1}是不同的，求子集里这两个是一样的子集；
* 所以在DFS递归中遍历子树状态时for循环应该是从上次的index后面开始，而不是从0开始；
* 在排列问题中，DFS for循环就是从0开始的，而这种问题需要记录上次index位置，并传给DFS
*
* 3、因为这是遍历全部子集的情况，所以可以没有return条件判断
* */

/*
* 整体来看，这就是一道很简单的回溯模板题；
* 下面代码是 时间100%，内存91.2%；
* */

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();

    void DFS(int[] nums, int startIndex){
        res.add(new ArrayList<>(list));
        for (int i = startIndex; i < nums.length; i++){
            list.add(nums[i]);
            DFS(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums){
        DFS(nums, 0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Hello, 78!");
    }
}
