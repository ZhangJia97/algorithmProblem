package LeetCode_Old;

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
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']++;
        }
        char[] sArr = s.toCharArray();
        int l = 0;
        int r = 0;
        int count = p.length();
        while (r < s.length()) {
            if (arr[sArr[r] - 'a']-- >= 1) {
                count--;
            }
            r++;
            if (count == 0) {
                result.add(l);
            }
            if (r - l == p.length()) {
                if (arr[sArr[l] - 'a']++ >= 0) {
                    count++;
                }
                l++;
            }
        }
        return result;
    }
}
