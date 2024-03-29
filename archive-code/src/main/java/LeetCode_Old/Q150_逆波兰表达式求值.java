package LeetCode_Old;

import java.util.Stack;

/**
 * @author zhangjia
 * @title: Q150_逆波兰表达式求值
 * @date 2019-04-26 15:22
 * <p>
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class Q150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            switch (str) {
                case "+": {
                    int num;
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    num = num2 + num1;
                    stack.push(num);
                    break;
                }
                case "-": {
                    int num;
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    num = num2 - num1;
                    stack.push(num);
                    break;
                }
                case "*": {
                    int num;
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    num = num2 * num1;
                    stack.push(num);
                    break;
                }
                case "/": {
                    int num;
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    num = num2 / num1;
                    stack.push(num);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(str));
                    break;
            }
        }
        return stack.pop();
    }
}
