package LeetCode_Old;

/**
 * @author zhangjia
 * @title: Q75_颜色分类
 * @date 2019-04-17 12:24
 * <p>
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * <p>
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Q75_颜色分类 {

    //三路快排
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        int i = 0;
        while (i < two) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[++zero];
                nums[zero] = tmp;
                i++;
            } else {
                int tmp = nums[i];
                nums[i] = nums[--two];
                nums[two] = tmp;
            }
        }
    }

    //计数排序
    public void sortColors1(int[] nums) {
        int[] arr = new int[3];
        for (int n : nums) {
            arr[n] += 1;
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arr[i]; j++) {
                nums[sum++] = i;
            }
        }
    }
}
