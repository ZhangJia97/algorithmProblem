package LeetCode_Old;

import LeetCode_Old.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q24_两两交换链表中的节点
 * @date 2019-04-25 21:36
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Q24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode node = dummyHead;
        while (head != null && head.next != null) {
            ListNode tmp = head.next;
            head.next = head.next.next;
            node.next = tmp;
            tmp.next = head;
            node = head;
            head = head.next;
        }
        return dummyHead.next;
    }
}
