import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 这道题就是nums数组中会有重复元素的情况；和之前的不同，之前的没有重复元素
* 按照套路，出现了重复元素就要考虑对数组进行排序；让重复元素相邻，方便处理；
* */

//public class Solution_90 {
//
//    public List<List<Integer>> res = new ArrayList<>();
//    public List<Integer> list = new ArrayList<>();
//    boolean[] visited;
//
//    public void DFS(int[] nums, int startIndex){
//        res.add(new ArrayList<>(list));
//        for (int i = startIndex; i < nums.length; i++){
//            if (i > 0 && nums[i-1] == nums[i] && !visited[i - 1])
//                continue;
//            list.add(nums[i]);
//            visited[i] = true;
//            DFS(nums, i + 1);
//            visited[i] = false;
//            list.remove(list.size() - 1);
//        }
//    }
//
//    public List<List<Integer>> subsetsWithDup(int[] nums){
//        Arrays.sort(nums);
//        visited = new boolean[nums.length];
//        DFS(nums, 0);
//        return res;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 90!");
//    }
//}

/*
* 上面的方法是一种传统的去重方法，即额外创建一个数组visited来记录每个节点是否被访问
* 但是，在这里，其实可以有更加高级的去重方式，不需要检测visited；
* 直接看index；
* */

/*
* 关于递归过程中，同一树层和同一分支；
* 同一树层是指for循环过程中，出现的所有数就是成为同一层；
* 这里的去重就是防止同一层中的重复，所以可以直接用index来判断，而不需要visited
* 这里不需要判断同一分支是否重复；
*
* 具体是同一层内重复还是不同层重复的情况；
* 这里显然是，同一个组合内部数字可以随便重复，但是不同组合的数不能重复；
* 那么就是同一分支重复没关系，但是同一for循环内不能重复；
* 就像是DFS和BFS的关系；
* */

//public class Solution_90 {
//
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
//
//    public void DFS(int[] nums, int startIndex){
//        res.add(new ArrayList<>(list));
//        for (int i = startIndex; i < nums.length; i++){
//            if (i > startIndex && nums[i-1] == nums[i])
//                continue;
//            list.add(nums[i]);
//            DFS(nums, i + 1);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    public List<List<Integer>> subsetsWithDup(int[] nums){
//        Arrays.sort(nums);
//        DFS(nums, 0);
//        return res;
//    }
//}


/*
 这个避免重复当思想是在是太重要了。
 这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
 1
 / \
 2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
 /     \
 5       5
 例2
 1
 /
 2      这种情况确是允许的
 /
 2

 为何会有这种神奇的效果呢？
 首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
 可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
 因为当第二个2出现的时候，他就和前一个2相同了。

 那么如何保留例2呢？
 那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
 例2的两个2是处在不同层级上的。
 在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
 必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
 第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.
 */

public class Solution_90 {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();

    public void DFS(int[] nums, int startIndex){
        res.add(new ArrayList<>(list));
        for (int i = startIndex; i < nums.length; i++){
            if (i > startIndex && nums[i-1] == nums[i])
                continue;
            list.add(nums[i]);
            DFS(nums, i+1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        DFS(nums, 0);
        return res;
    }
}
























