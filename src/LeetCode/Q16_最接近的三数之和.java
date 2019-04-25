package LeetCode;

import java.util.Arrays;

/**
 * @author zhangjia
 * @title: Q16_最接近的三数之和
 * @date 2019-04-22 22:49
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Q16_最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int minNum = Integer.MAX_VALUE;
        if (nums.length < 3) {
            return minNum;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int tmpNum = nums[i] + nums[l] + nums[r];
                int tmpDiff = Math.abs(tmpNum - target);
                if (tmpDiff == 0) {
                    return tmpNum;
                }
                if (tmpDiff < minDiff) {
                    minDiff = tmpDiff;
                    minNum = tmpNum;
                }
                if (tmpNum < target) {
                    l++;
                } else if (tmpNum > target) {
                    r--;
                }
            }
        }
        return minNum;
    }
}
