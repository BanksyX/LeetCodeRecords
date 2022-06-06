/*
* Leetcode 146；
* LRU缓存机制的简单实现；
* 实现三个基本操作
* 1、LRUCache初始化；2、put放入元素操作；3、get获取元素操作；
* 要求，所有操作都在O(1)常数时间复杂度内实现；
*
* 关键步骤在于，如何维护每个元素的时效性
* 即一直没使用的最先被淘汰，被使用过就刷新时间；
*
* 实现方法
* 这里主要是靠搭建新的数据结构来实现
* 双链表 + HashMap实现
* 双链表能够维持元素的时效性，即作为一个队列，一头删除一头插入，但不满足O(1)时间复杂度
* HashMap能够满足快速查询添加O(1)时间复杂度，但是不能满足时效性；
* 所以结合两者进行实现；
*
* Java中已经实现了这种数据结构，即LinkedHashMap，底层就是这两个数据结构实现的；
*
* 关于这个数据结构的实现，有 三 层 封 装 ；
* 最顶层就是上面描述的三个基本操作，LRUCache init、put、get
* 然后底层封装了几个基本操作来支持上面的三种操作；
* 主要包括:
* 1、双链表层面，双链表的设计与实现，元素添加删除、第一个元素的删除等
* 2、在双链表基础上，完成元素添加、删除操作，将某个key提升为最近使用状态
* 删除最久未使用元素，
* 3、在上面两个层面实现的情况下，实现put、get、初始化操作；
* */

//import java.util.HashMap;
//
//public class Solution_146 {
//
//    private HashMap<Integer, Node> map;
//    private DoubleList cache;
//    private int cap;
//
//    public Solution_146(int capacity){
//        this.cap = capacity;
//        map = new HashMap<>();
//        cache = new DoubleList();
//    }
//
//    // 将key提升为最近使用的，刷新操作
//    private void makeRecently(int key){
//        Node x = map.get(key);
//        cache.remove(x);
//        cache.addLast(x);
//    }
//
//    // 添加最近使用的元素
//    private void addRecently(int key, int val){
//        Node x = new Node(key, val);
//        cache.addLast(x);
//        map.put(key, x);
//    }
//
//    // 删除某一个key
//    private void deleteKey(int key){
//        Node x = map.get(key);
//        cache.remove(x);
//        map.remove(key);
//    }
//
//    // 删除最久未使用的元素
//    private void removeLeastRecently(){
//        // 链表头部的第一个元素是最久未使用的
//        Node deleteNode = cache.removeFirst();
//        int deleteKey = deleteNode.key;
//        map.remove(deleteKey);
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello, 146!");
//    }
//}
//

/*
* 我们之所以要用到HashMap就是因为Map能够提供快速查询，实现O(1)的时间效率
* 而这是双链表无法做到的；
* */

import java.util.LinkedHashMap;

public class Solution_146 {
    public int cap;
    public LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public Solution_146(int capacity){
        this.cap = capacity;
    }

    public void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }

    public int get(int key){
        if (!cache.containsKey(key))
            return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int val){
        if (cache.containsKey(key)){
            cache.put(key, val);
            makeRecently(key);
            return;
        }

        if (cache.size() >= this.cap){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key, val);
    }
}


























