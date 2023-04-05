package LeetCode_Old;

import java.util.Arrays;

/**
 * @author zhangjia
 * @title Q343_整数拆分
 * @date 2019-09-21 14:22
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q343_整数拆分 {

    static int[] nums;

    public int integerBreak(int n) {
        nums = new int[n + 1];
        return get(n);
    }

    private int get(int n) {
        if (n == 1) {
            return 1;
        }
        if (nums[n] != 0) {
            return nums[n];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.max(Math.max(res, i * (n - i)), i * get(n - i));
        }
        nums[n] = res;
        return res;
    }

    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.println("----");
                System.out.println(dp[i]);
                System.out.println(j * (i - j));
                System.out.println(j * dp[i - j]);
                dp[i] = Math.max(Math.max(dp[i], j * (i - j)), j * dp[i - j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
