package LeetCode_Old;

import java.util.*;

/**
 * @author zhangjia
 * @title: Q347_前K个高频元素
 * @date 2019-05-10 16:01
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class Q347_前K个高频元素 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue() - o1.getValue()
        );
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            resList.add(priorityQueue.poll().getKey());
        }
        return resList;
    }
}
