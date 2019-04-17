package LeetCode;

/**
 * @author zhangjia
 * @title: Q209_长度最小的子数组
 * @date 2019-04-17 18:03
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Q209_长度最小的子数组 {
    public static void main(String[] args) {
        int[] map = new int[2];
        map[0] = 5;
        map[1] = 6;
        if (map[0]-- >= 5) {
            System.out.println(map[0]);
        }
        System.out.println(map[0]--);
    }


    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
