package 程序员代码面试指南;

import java.util.Stack;

/**
 * @author zhangjia
 * @title Q2_由两个栈组成的队列
 * @date 2020/1/3 20:11
 * @description //todo
 * 【题目】
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。
 */
public class Q2_由两个栈组成的队列 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void add(int num) {
        stack2.push(num);
    }

    public int poll() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("stack is empty");
        }
        pushToPop();
        return stack1.pop();
    }

    public int peek() {
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("stack is empty");
        }
        pushToPop();
        return stack1.peek();
    }

    private void pushToPop() {
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public static void main(String[] args) {
        Q2_由两个栈组成的队列 q2_由两个栈组成的队列 = new Q2_由两个栈组成的队列();
        q2_由两个栈组成的队列.add(1);
        System.out.println(q2_由两个栈组成的队列.peek());
        q2_由两个栈组成的队列.add(2);
        System.out.println(q2_由两个栈组成的队列.poll());
        System.out.println(q2_由两个栈组成的队列.peek());
        q2_由两个栈组成的队列.peek();
        q2_由两个栈组成的队列.add(3);
        q2_由两个栈组成的队列.add(4);
        System.out.println(q2_由两个栈组成的队列.poll());
        System.out.println(q2_由两个栈组成的队列.peek());
        q2_由两个栈组成的队列.add(5);
        q2_由两个栈组成的队列.poll();
        System.out.println(q2_由两个栈组成的队列.peek());
        q2_由两个栈组成的队列.poll();
        System.out.println(q2_由两个栈组成的队列.peek());
        q2_由两个栈组成的队列.poll();
        System.out.println(q2_由两个栈组成的队列.peek());
    }
}
