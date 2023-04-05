package LeetCode_Old;

import LeetCode_Old.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q2_两数相加
 * @date 2019-04-25 19:11
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2_两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode head = dummyHead;
        int flag = 0;
        while (l1 != null && l2 != null) {
            int num = (l1.val + l2.val + flag) % 10;
            flag = (l1.val + l2.val + flag) / 10;
            head.next = new ListNode(num);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = (l1.val + flag) % 10;
            flag = (l1.val + flag) / 10;
            head.next = new ListNode(num);
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num = (l2.val + flag) % 10;
            flag = (l2.val + flag) / 10;
            head.next = new ListNode(num);
            head = head.next;
            l2 = l2.next;
        }
        if (flag != 0) {
            head.next = new ListNode(flag);
            head = head.next;
        }
        head.next = null;
        return dummyHead.next;
    }
}
