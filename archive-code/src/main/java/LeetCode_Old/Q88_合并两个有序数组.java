package LeetCode_Old;

/**
 * @author zhangjia
 * @title: Q88_合并两个有序数组
 * @date 2019-04-17 12:41
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 */
public class Q88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int len = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[len--] = nums2[j--];
            } else {
                nums1[len--] = nums1[i--];
            }
        }
        while (i >= 0) {
            nums1[len--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[len--] = nums2[j--];
        }
    }
}
