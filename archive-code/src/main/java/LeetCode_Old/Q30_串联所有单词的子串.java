package LeetCode_Old;

import java.util.*;

/**
 * @author zhangjia
 * @title: Q30_串联所有单词的子串
 * @date 2019/7/24 8:49
 * <p>
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1：
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * 示例 2：
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q30_串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        int len = words.length;
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> tmpMap = new HashMap<>();
            int count = 0;
            int left = i;
            int right = i;
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (!map.containsKey(word)) {
                    count = 0;
                    left = right;
                    tmpMap.clear();
                } else {
                    tmpMap.put(word, tmpMap.getOrDefault(word, 0) + 1);
                    count++;
                    while (tmpMap.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                        String tmpWord = s.substring(left, left + wordLen);
                        left += wordLen;
                        count--;
                        tmpMap.put(tmpWord, tmpMap.getOrDefault(tmpWord, 0) - 1);
                    }
                    if (count == len) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}