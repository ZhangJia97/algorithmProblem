package 程序员代码面试指南;

import 程序员代码面试指南.Q6.State;

import java.util.Stack;

/**
 * @author zhangjia
 * @title Q6_扩展解法_借助栈实现
 * @date 2020/1/5 14:55
 * @description //todo
 */
public class Q6_扩展_基本实现_非递归 {

    public void hanoi(int n, String x, String y, String z) {
        Stack<State> s = new Stack<>();
        s.push(new State(n, x, y, z));
        State state;
        while (!s.empty() && (state = s.pop()) != null) {
            if (state.n == 1) {
                System.out.println(state.x + " -> " + state.y);
            } else {
                // 栈结构先进后出，所以需要逆序进栈
                s.push(new State(state.n - 1, state.y, state.x, state.z));
                s.push(new State(1, state.x, state.y, state.z));
                s.push(new State(state.n - 1, state.x, state.z, state.y));
            }
        }
    }

    public static void main(String[] args) {
        Q6_扩展_基本实现_非递归 q6_扩展__基本实现_非递归 = new Q6_扩展_基本实现_非递归();
        System.out.println();
        System.out.println("非递归方式：");
        q6_扩展__基本实现_非递归.hanoi(3, "x", "y", "z");
    }
}
