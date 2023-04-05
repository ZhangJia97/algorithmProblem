package LeetCode.leetcode.editor.cn;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1502 👎 0

import LeetCode.leetcode.editor.cn.comm.ListNode;

class SwapNodesInPairs{
	public static void main(String[] args) {
		Solution solution = new SwapNodesInPairs().new Solution();
		
	}
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
		ListNode node = new ListNode(0, head);
		ListNode start = node;
		while (head != null && head.next != null) {
			final ListNode n1 = head;
			final ListNode n2 = head.next;
			head = head.next.next;
			node.next = n2;
			node.next.next = n1;
			node = node.next.next;
		}
		if (head != null) {
			node.next = head;
			node.next.next = null;
		}else {
			node.next = null;
		}
		return start.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
