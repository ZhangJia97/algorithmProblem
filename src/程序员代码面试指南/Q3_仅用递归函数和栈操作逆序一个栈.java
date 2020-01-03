package 程序员代码面试指南;

import java.util.Stack;

/**
 * @author zhangjia
 * @title Q3_仅用递归函数和栈操作逆序一个栈
 * @date 2020/1/3 20:33
 * @description //todo
 * 【题目】
 *  一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 *  将这个栈转置后，从栈顶到栈底为 1、2、3、4、5，也就是实现栈中元素的逆序，
 *  但是只能用递归函数来实现，不能用其他数据结构。
 */
public class Q3_仅用递归函数和栈操作逆序一个栈 {
    public int getAndRemoveLastElement(Stack<Integer> stack){
        int num = stack.pop();
        if (stack.empty()){
            return num;
        }
        int result = getAndRemoveLastElement(stack);
        stack.push(num);
        return result;
    }

    public void reverse(Stack<Integer> stack){
        if (stack.empty()){
            return;
        }
        int lastElement = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(lastElement);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        Q3_仅用递归函数和栈操作逆序一个栈 q3_仅用递归函数和栈操作逆序一个栈 = new Q3_仅用递归函数和栈操作逆序一个栈();
        System.out.println(q3_仅用递归函数和栈操作逆序一个栈.getAndRemoveLastElement(stack));
        System.out.println(stack);
        q3_仅用递归函数和栈操作逆序一个栈.reverse(stack);
        System.out.println(stack);
    }
}
