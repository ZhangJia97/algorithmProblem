package 程序员代码面试指南;

/**
 * @author zhangjia
 * @title Q6_汉诺塔问题_基本实现
 * @date 2020/1/5 16:10
 * @description //todo
 */
public class Q6_扩展_基本实现_递归 {
    // 常见的汉诺塔问题
    public static void hanoi(int n, String x, String y, String z) {
        if (n == 1) {
            System.out.println(x + " -> " + z);
        } else {
            hanoi(n - 1, x, z, y);
            System.out.println(x + " -> " + z);
            hanoi(n - 1, y, x, z);
        }
    }
}
