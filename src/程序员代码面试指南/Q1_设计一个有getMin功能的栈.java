package 程序员代码面试指南;

import java.util.Stack;

/**
 * @author zhangjia
 * @title Q1_设计一个有getMin功能的栈
 * @date 2020/1/3 19:51
 * @description //todo
 *
 * 【题目】
 *  实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 *
 * 【要求】
 *  1.pop、push、getMin操作的时间复杂度都是O（1）。
 *  2.设计的栈类型可以使用现成的栈结构。
 */
public class Q1_设计一个有getMin功能的栈 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public Integer pop() {
        if (stack.empty()){
            throw new RuntimeException("stack为空");
        }
        int result = stack.pop();
        minStack.pop();
        return result;
    }

    public void push(int num){
        int min = minStack.empty() ? num : minStack.peek();
        minStack.push(Math.min(num, min));
        stack.push(num);
    }

    public Integer getMin() {
        if (stack.empty()){
            throw new RuntimeException("stack为空");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        Q1_设计一个有getMin功能的栈 q1_设计一个有getMin功能的栈 = new Q1_设计一个有getMin功能的栈();
        q1_设计一个有getMin功能的栈.push(7);
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        q1_设计一个有getMin功能的栈.push(4);
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        q1_设计一个有getMin功能的栈.push(5);
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        q1_设计一个有getMin功能的栈.push(8);
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        q1_设计一个有getMin功能的栈.push(2);

        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        System.out.println(q1_设计一个有getMin功能的栈.pop());
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        System.out.println(q1_设计一个有getMin功能的栈.pop());
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        System.out.println(q1_设计一个有getMin功能的栈.pop());
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        System.out.println(q1_设计一个有getMin功能的栈.pop());
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
        System.out.println(q1_设计一个有getMin功能的栈.pop());
        System.out.println("min = " + q1_设计一个有getMin功能的栈.getMin());
    }
}
