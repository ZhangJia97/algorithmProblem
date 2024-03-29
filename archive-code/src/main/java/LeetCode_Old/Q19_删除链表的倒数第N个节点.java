package LeetCode_Old;

import LeetCode_Old.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q19_删除链表的倒数第N个节点
 * @date 2019-04-26 13:32
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class Q19_删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode last = dummyHead;
        while (n > 0) {
            if (last.next != null) {
                last = last.next;
                n--;
            } else {
                return dummyHead.next;
            }
        }
        while (last.next != null) {
            last = last.next;
            first = first.next;
        }
        first.next = first.next.next;
        return dummyHead.next;
    }
}
