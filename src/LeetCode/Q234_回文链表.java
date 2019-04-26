package LeetCode;

import LeetCode.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q234_回文链表
 * @date 2019-04-26 14:41
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 *  示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Q234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        while(pre != null && head != null){
            if(pre.val == head.val){
                pre = pre.next;
                head = head.next;
            }else {
                return false;
            }
        }
        return true;
    }
}
