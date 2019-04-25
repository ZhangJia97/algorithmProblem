package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjia
 * @title: Q290_单词模式
 * @date 2019-04-22 20:01
 * <p>
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * <p>
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * <p>
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Q290_单词模式 {

    public boolean wordPattern(String pattern, String str) {
        String[] sArr = str.split(" ");
        if (pattern.length() != sArr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        boolean flag = true;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(sArr[i])) {
                    flag = false;
                    break;
                }
            } else {
                if (!map.containsValue(sArr[i])) {
                    map.put(pattern.charAt(i), sArr[i]);
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }
}
