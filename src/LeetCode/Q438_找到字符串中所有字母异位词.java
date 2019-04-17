package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjia
 * @title: Q438_找到字符串中所有字母异位词
 * @date 2019-04-17 19:37
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * <p>
 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * <p>
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Q438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length())
            return result;
        int[] map = new int[26];
        for (char ch : p.toCharArray())
            map[ch - 'a']++;
        int count = p.length();
        int left = 0, right = 0;
        char[] ss = s.toCharArray();
        while (right < s.length()) {
            if (map[ss[right] - 'a']-- >= 1)
                count--;
            right++;
            if (count == 0)
                result.add(left);
            if (right - left == p.length()) {
                if (map[ss[left] - 'a']++ >= 0)
                    count++;
                left++;
            }
        }
        return result;
    }
}
