package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhangjia
 * @title: Q20_有效的括号
 * @date 2019-04-26 15:07
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 *  示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 *  示例 3:
 * 输入: "(]"
 * 输出: false
 *
 *  示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 *  示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Q20_有效的括号 {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek() != map.get(c)){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
