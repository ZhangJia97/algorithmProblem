package LeetCode.leetcode.editor.cn.comm;

/**
 * @author zhangjia
 * @title: ListNode
 * @date 2019-04-25 17:20
 * <p>
 * 链表的Node节点
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
