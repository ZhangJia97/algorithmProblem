package LeetCode;

import LeetCode.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjia
 * @title: Q107_二叉树的层次遍历II
 * @date 2019-04-27 10:47
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Q107_二叉树的层次遍历II {
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) return;
        if (level == levels.size())
            levels.add(0, new ArrayList<>());
        if (root.left != null)
            helper(root.left, level + 1);
        if (root.right != null) helper(root.right, level + 1);
        levels.get(levels.size() - 1 - level).add(root.val);
    }
}
