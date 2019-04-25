package LeetCode;

import LeetCode.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q86_分隔链表
 * @date 2019-04-25 17:32
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Q86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while(head != null){
            if(head.val < x){
                node1.next = head;
                node1 = node1.next;
            }else{
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node2.next = null;
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
