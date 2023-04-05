package LeetCode_Old;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhangjia
 * @title: Q349_两个数组的交集
 * @date 2019-04-22 17:01
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * <p>
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Q349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums1) {
            list.add(num);
        }
        for (int num : nums2) {
            if (list.contains(num)) {
                set.add(num);
            }
        }

        int[] result = new int[set.size()];
        int index = 0;

        Iterator<Integer> iter = set.iterator();

        while (iter.hasNext()) {
            result[index] = iter.next();
            index++;
        }
        return result;
    }
}
