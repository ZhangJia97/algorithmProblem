package 程序员代码面试指南;

import java.util.Stack;

/**
 * @author zhangjia
 * @title Q5_用一个栈实现另一个栈的排序
 * @date 2020/1/4 19:26
 * @description //todo
 * 【题目】
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 */
public class Q5_用一个栈实现另一个栈的排序 {

    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!helpStack.empty() && cur > helpStack.peek()) {
                stack.push(helpStack.pop());
            }
            helpStack.push(cur);
        }
        while (!helpStack.empty()) {
            stack.push(helpStack.pop());
        }
    }

    public static void main(String[] args) {
        Q5_用一个栈实现另一个栈的排序 q5_用一个栈实现另一个栈的排序 = new Q5_用一个栈实现另一个栈的排序();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(10);
        q5_用一个栈实现另一个栈的排序.sortStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
