package LeetCode;

import LeetCode.comm.ListNode;

/**
 * @author zhangjia
 * @title: Q147_对链表进行插入排序
 * @date 2019-04-26 10:43
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 *  示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class Q147_对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        ListNode fakeNode=new ListNode(-1);
        fakeNode.next=head;
        if(head==null)
            return null;
        ListNode cur=head.next;//从第二个节点开始遍历
        ListNode pre=head;//排好序的最后一个节点
        while(cur!=null)
        {
            if(cur.val<pre.val)
            {
                ListNode nextNode=cur.next;//保存下一个需要遍历的节点

                //寻找插入的合适位置
                ListNode cur2=fakeNode.next;
                ListNode temp=fakeNode;//记录cur2前面一个节点
                while(cur.val>cur2.val&&cur2!=pre)
                {
                    temp=cur2;
                    cur2=cur2.next;
                }
                //进行插入
                temp.next=cur;
                cur.next=cur2;
                pre.next=nextNode;
                //继续遍历下一个节点
                cur=nextNode;
            }
            else {
                pre=cur;
                cur=cur.next;
            }

        }
        return fakeNode.next;
    }
}
