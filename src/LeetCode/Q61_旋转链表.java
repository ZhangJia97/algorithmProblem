package LeetCode;

import LeetCode.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q61_旋转链表
 * @date 2019-04-26 13:45
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Q61_旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode last = dummyHead;
        ListNode tmp = head;
        int cnt = 0;
        while (tmp != null) {
            cnt++;
            tmp = tmp.next;
        }
        k = k % cnt;
        while (k > 0) {
            last = last.next;
            k--;
        }
        while (last.next != null) {
            last = last.next;
            first = first.next;
        }
        last.next = dummyHead.next;
        dummyHead.next = first.next;
        first.next = null;
        return dummyHead.next;

    }
}
