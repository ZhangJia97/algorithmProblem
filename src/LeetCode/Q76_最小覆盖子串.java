package LeetCode;

/**
 * @author zhangjia
 * @title: Q76_最小覆盖子串
 * @date 2019-04-17 21:47
 * <p>
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * <p>
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Q76_最小覆盖子串 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        //转化成数组，提升查找速度
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int[] map = new int[256];//利用ASSII码做映射，比hashmap效率高
        for (int i = 0; i < n; i++) {
            map[T[i]]++;
        }
        int start = -1;
        int L = 0, R = 0;//滑动窗口[L,R]
        int count = 0;//保存窗口里已经找到了多少字符
        int min = m + 1;
        while (L <= m - n && R < m) {
            map[S[R]]--;
            if (map[S[R]] >= 0) {
                count++;
            }
            if (count == n) {
                while (map[S[L]] < 0) {//L尽量往左移动
                    map[S[L]]++;
                    L++;
                }
                if (R - L < min) {//记录位置
                    min = R - L;
                    start = L;
                }
                map[S[L++]]++;//L继续右移一位，进行下次寻找
                count--;
            }
            R++;
        }
        if (min < m + 1) {
            return s.substring(start, start + min + 1);
        }
        return "";
    }
}
