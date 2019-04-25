package LeetCode;

import LeetCode.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q83_删除排序链表中的重复元素
 * @date 2019-04-25 17:19
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 *  示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Q83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null){
            if(cur.val != next.val){
                cur = next;
                next = next.next;
            }else{
                next = next.next;
                cur.next = next;
            }
        }
        return dummyHead.next;
    }

}
