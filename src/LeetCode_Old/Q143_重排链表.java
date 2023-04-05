package LeetCode_Old;

import LeetCode_Old.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q143_重排链表
 * @date 2019-04-26 14:25
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class Q143_重排链表 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow.next;
        ListNode pre = null;
        slow.next = null;
        while (node != null) {
            ListNode tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        while (head != null && pre != null) {
            ListNode nextTemp = head.next, preNextTemp = pre.next;
            head.next = pre;
            pre.next = nextTemp;
            head = nextTemp;
            pre = preNextTemp;
        }
    }
}
