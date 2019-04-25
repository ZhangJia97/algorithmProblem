package LeetCode;

import LeetCode.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q203_移除链表元素
 * @date 2019-04-25 20:02
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Q203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        ListNode next = head;
        while (next != null) {
            if (next.val != val) {
                cur.next = next;
                next = next.next;
                cur = cur.next;
            } else {
                next = next.next;
                cur.next = next;
            }
        }
        return dummyHead.next;
    }
}
