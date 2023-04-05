package LeetCode_Old;

import LeetCode_Old.comm.TreeNode;

import java.util.*;

/**
 * @author zhangjia
 * @title: Q103_二叉树的锯齿形层次遍历
 * @date 2019-05-02 13:54
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Q103_二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            while (size != 0) {
                TreeNode node = queue.poll();
                tmpList.add(node.val);
                size--;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (flag) {
                Collections.reverse(tmpList);
            }
            flag = !flag;
            list.add(tmpList);
        }
        return list;
    }
}
