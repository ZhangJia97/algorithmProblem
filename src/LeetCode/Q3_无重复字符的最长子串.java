package LeetCode;

/**
 * @author zhangjia
 * @title: Q3_无重复字符的最长子串
 * @date 2019-04-17 18:18
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Q3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int l = 0;
        int r = -1;
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && arr[s.charAt(r + 1)] == 0) {
                arr[s.charAt(++r)] += 1;
            } else {
                arr[s.charAt(l)] -= 1;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
