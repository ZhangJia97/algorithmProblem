package LeetCode2018高频面试题;

/**
 * 求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Q1_2_求众数 {
    public int majorityElement(int[] nums) {
        int num = 0;
        int res = 0;
        for (int i : nums) {
            if (num <= 0) {
                res = i;
                num++;
            } else {
                if (i == res) {
                    num++;
                } else {
                    num--;
                }
            }
        }
        return res;
    }
}
