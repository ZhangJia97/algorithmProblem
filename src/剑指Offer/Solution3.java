package 剑指Offer;

/**
 * 数组中的重复数字
 *
 * 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 注意：如果某些数字不在 0∼n−1 的范围内，或数组中不包含重复数字，则返回 -1；
 *
 * 样例
 *
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 * 返回 2 或 3。
 *
 */
public class Solution3 {
    public int duplicateInArray(int[] nums) {
        //判断是否有非法值
        for(int i : nums){
            if(i < 0 || i >= nums.length - 1){
                return -1;
            }
        }
        //对数组进行遍历
        for(int i = 0; i < nums.length; i++){
            // 若当前值不等于当前下标，则将当前值与以当前值为下标的值互换，
            // 如以当前值为下标的值等于当前值则找到重复数字
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }
}
