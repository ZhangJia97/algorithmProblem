package leetcode.editor.cn;

//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 双指针 👍 1866 👎 0

import java.util.Arrays;

class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        final int[] ints = {3, 2, 1};
        solution.nextPermutation(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n1 = nums.length - 1;
            int n2 = nums.length - 1;
            int n3 = nums.length - 1;
            // 获取从后往前第一个非降序数字
            while (n1 > 0) {
                n1--;
                if (nums[n1] < nums[n1 + 1]) {
                    break;
                }
            }

            // 获取从后往前第一个比nums[n1]大的数字
            while (n2 > n1) {
                if (nums[n2] > nums[n1]) {
                    break;
                } else {
                    n2--;
                }
            }

            // n1 == n2 说明整个字符为降序，直接翻转
            if (n1 == n2) {
                while (n1 < n3) {
                    swap(nums, n1, n3);
                    n1++;
                    n3--;
                }
                return;
            }

            // 交换nums[n1] nums[n2]
            swap(nums, n1, n2);

            // 将n1+1后的数组进行翻转
            n1++;
            while (n1 < n3) {
                swap(nums, n1, n3);
                n1++;
                n3--;
            }
        }

        private void swap(int[] nums, int n1, int n2) {
            final int n = nums[n2];
            nums[n2] = nums[n1];
            nums[n1] = n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
