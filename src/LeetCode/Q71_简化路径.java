package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhangjia
 * @title: Q71_简化路径
 * @date 2019-04-26 15:40
 */
public class Q71_简化路径 {
    public String simplifyPath(String path) {
        String[] strArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strArr) {
            if (str.equals(".") || str.equals("")) {
                continue;
            } else if (str.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!str.equals("..")) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = "/" + stack.pop() + str;
        }
        return str;
    }
}