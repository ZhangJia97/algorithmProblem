package LeetCode;

import java.util.PriorityQueue;

/**
 * @author zhangjia
 * @title: Q215_数组中的第K个最大元素
 * @date 2019-04-17 14:17
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Q215_数组中的第K个最大元素 {

    //快排
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 1) {
            return -1;
        }
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] a, int left, int right, int k) {
        if (left < right) {
            swap(a, right, left + (int) (Math.random() * (right - left + 1)));
            int[] res = sort(a, left, right);
            if (res[0] >= k) {
                return quickSort(a, left, res[0], k);
            } else if (res[1] <= k) {
                return quickSort(a, res[1], right, k);
            } else {
                return a[res[0] + 1];
            }
        }
        return a[left];
    }

    public int[] sort(int[] a, int left, int right) {
        int i = left - 1, j = right;
        while (left < j) {
            if (a[left] < a[right]) {
                swap(a, ++i, left++);
            } else if (a[left] == a[right]) {
                left++;
            } else {
                swap(a, --j, left);
            }
        }
        swap(a, j, right);
        return new int[]{i, j + 1};
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //优先队列
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        System.out.println(queue);
        for (int i = nums.length - 1; i > -1 ; i--) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll();
    }
}
