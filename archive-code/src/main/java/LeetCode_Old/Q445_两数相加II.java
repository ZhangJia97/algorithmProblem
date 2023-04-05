package LeetCode_Old;

import LeetCode_Old.comm.ListNode;

import java.util.Stack;

/**
 * @author zhangjia
 * @title: Q445_两数相加II
 * @date 2019-04-25 19:32
 * <p>
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class Q445_两数相加II {
    /**
     * 方法一：先翻转链表，再链表归并
     * 方法二：使用栈来实现
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int flag = 0;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int num1 = stack1.pop();
            int num2 = stack2.pop();
            int num = (num1 + num2 + flag) % 10;
            flag = (num1 + num2 + flag) / 10;
            stack.push(num);
        }
        while (!stack1.isEmpty()) {
            int num1 = stack1.pop();
            int num = (num1 + flag) % 10;
            flag = (num1 + flag) / 10;
            stack.push(num);
        }
        while (!stack2.isEmpty()) {
            int num2 = stack2.pop();
            int num = (num2 + flag) % 10;
            flag = (num2 + flag) / 10;
            stack.push(num);
        }
        if (flag > 0) {
            stack.push(flag);
        }
        while (!stack.isEmpty()) {
            head.next = new ListNode(stack.pop());
            head = head.next;
        }
        head.next = null;
        return dummyHead.next;
    }
}
