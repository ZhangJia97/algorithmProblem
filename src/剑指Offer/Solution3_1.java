package 剑指Offer;

/**
 * 不修改数组找出重复的数字
 *
 * 给定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
 * 请找出数组中任意一个重复的数，但不能修改输入的数组。
 *
 * 样例
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 * 返回 2 或 3。
 *
 * 思考题：如果只能使用 O(1) 的额外空间，该怎么做呢？
 */
public class Solution3_1 {
    public int duplicateInArray(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while(start <= end){
            int middle = (start + end) / 2;
            int count = getNum(nums, start, middle);
            if(start == end){
                if(count > 1){
                    return start;
                }else{
                    return -1;
                }
            }
            if(count > middle - start + 1){
                end = middle;
            }else{
                start = middle + 1;
            }
        }
        return -1;
    }

    public int getNum(int[] nums, int start, int middle){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= start && nums[i] <= middle){
                count++;
            }
        }
        return count;
    }
}
