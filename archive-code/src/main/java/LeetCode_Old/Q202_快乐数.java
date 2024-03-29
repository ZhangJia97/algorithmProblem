package LeetCode_Old;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjia
 * @title: Q202_快乐数
 * @date 2019-04-22 19:38
 * <p>
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * <p>
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Q202_快乐数 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
                int sum = 0;
                while (n != 0) {
                    sum += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = sum;
            }
        }
        return true;
    }
}
