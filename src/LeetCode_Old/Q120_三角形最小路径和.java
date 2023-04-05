package LeetCode_Old;

import java.util.List;

/**
 * @author zhangjia
 * @title Q120_三角形最小路径和
 * @date 2019-09-21 10:05
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q120_三角形最小路径和 {
    static int[][] nums;

    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0);
    }

    public int minimumTotal(List<List<Integer>> triangle, int i, int j) {
        int row = triangle.size();
        if (i == row) {
            return triangle.get(i).get(j);
        }
        return Math.min(minimumTotal(triangle, i + 1, j), minimumTotal(triangle, i + 1, j + 1));
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        nums = new int[triangle.size()][triangle.get(0).size()];
        return helper(triangle, 0, 0);
    }

    public int helper(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (nums[i][j] != 0) {
            return nums[i][j];
        }
        nums[i][j] = Math.min(helper(triangle, i + 1, j), helper(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
        return nums[i][j];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] nums = new int[row][row];
        for (int i = 0; i < row; i++) {
            nums[row - 1][i] = triangle.get(row - 1).get(i);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                nums[i][j] = Math.min(nums[i + 1][j], nums[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return nums[0][0];
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

}
