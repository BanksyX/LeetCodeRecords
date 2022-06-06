
/*
* 关于这道题，可以设置一个队列；
* 这个队列是特殊的，即每个队列不止存储一个value；同时还要存储当前队列中最大的元素；
* 队列总大小为滑动窗口的大小k，然后每次对队列进行输出时，就获取最大值。
* */


/*
* 这道题；官方题解给出了三种方案；
* 每种方案都在上一种基础上进行了优化；
* 1、最原始的自然是暴力求解O(n^2)这会很慢啦；
* 2、初步优化就是采用 优先队列 的数据结构，即大小堆，这时复杂度将为O(nlogn)
* 3、最后优化是 采用 单调队列 这种数据结构，能够实现O(n)的时间复杂度；
* 单调队列，这里就是在队列内部维护一个单调递减的队列，然后具体实现是通过双端队列
* 双端队列左右两端都可以对元素进行出入操作；
* 最左侧的元素是队列中的最大元素；
* 然后唯一需要注意的在于，从最右侧加入元素时，需要和队列中已有的元素进行对比
* 如果大小不符合降序，那么就要删除队列中较小的元素；
* */


//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution_239 {
//    public int[] maxSlidingWindow(int[] nums, int k){
//        int n = nums.length;
//        Deque<Integer> deque = new LinkedList<Integer>();
//        for (int i = 0; i < k; i++){
//            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
//                deque.pollLast();
//            deque.offerLast(i);
//        }
//
//        int[] ans = new int[n - k + 1];
//        ans[0] = nums[deque.peekFirst()];
//        for (int i = k; i < n; i++){
//            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
//                deque.pollLast();
//            deque.offerLast(i);
//            while (deque.peekFirst() <= i-k)
//                deque.pollFirst();
//            ans[i-k+1] = nums[deque.peekFirst()];
//        }
//        return ans;
//    }
//}

/*
* 双端队列+index实现
* 需要注意的就是，队尾元素的加入和队首元素的删除，滑动窗口边界的更新
* */
//
//import java.util.Deque;
//import java.util.LinkedList;
//
//public class Solution_239 {
//    public int[] maxSlidingWindow(int[] nums, int k){
//        Deque<Integer> deque = new LinkedList<>();
//        int[] res = new int[nums.length - k + 1];
//        for (int right = 0; right < nums.length; right++){
//            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right])
//                deque.pollLast();
//            deque.addLast(right);
//            int left = right-k+1;
//            if (deque.peekFirst() < left)
//                deque.pollFirst();
//            if (right + 1 > k)
//                res[right-k+1] = nums[deque.peekFirst()];
//        }
//        return res;
//    }
//}
//

import java.util.Deque;

public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
    // 窗口个数
    int[] res = new int[nums.length - k + 1];
    Deque<Integer> queue = new LinkedList<>();

    // 遍历数组中元素，right表示滑动窗口右边界
    for(int right = 0; right < nums.length; right++) {
        // 如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
        // 直到，队列为空或当前考察元素小于新的队尾元素
        while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
            queue.removeLast();
        }

        // 存储元素下标
        queue.addLast(right);

        // 计算窗口左侧边界
        int left = right - k +1;
        // 当队首元素的下标小于滑动窗口左侧边界left时
        // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
        if (queue.peekFirst() < left) {
            queue.removeFirst();
        }

        // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
        // 意味着窗口形成。此时，队首元素就是该窗口内的最大值
        if (right +1 >= k) {
            res[left] = nums[queue.peekFirst()];
        }
    }
    return res;
    }
}


// 这道题还可以用优先队列来实现，这里就不写了





















