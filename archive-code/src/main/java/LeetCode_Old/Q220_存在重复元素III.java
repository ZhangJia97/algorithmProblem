package LeetCode_Old;

import java.util.TreeSet;

/**
 * @author zhangjia
 * @title: Q220_存在重复元素III
 * @date 2019-04-25 15:47
 * <p>
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class Q220_存在重复元素III {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 滑动窗口结合查找表，此时滑动窗口即为查找表本身（控制查找表的大小即可控制窗口大小）
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 边添加边查找
            // 查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
            // 添加后，控制查找表（窗口）大小，移除窗口最左边元素
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (k == 10000) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long l1 = nums[i];
                long l2 = nums[j];
                if ((Math.abs(l1 - l2) <= t)) {
                    if ((j - i) <= k)
                        return true;
                }
            }
        }
        return false;
    }
}
