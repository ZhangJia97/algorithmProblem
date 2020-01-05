package LeetCode;

import LeetCode.comm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangjia
 * @title: Q145_二叉树的后序遍历
 * @date 2019-04-26 21:54
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Q145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点。
        List<Integer> list = new ArrayList<>();

        while (root != null || !stack.empty()) {
            while (root != null) {//将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(root);
                stack2.push(left);
                root = root.left;
            }
            while (!stack.empty() && stack2.peek() == right) {//如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack2.pop();
                list.add(stack.pop().val);
            }
            if (!stack.empty() && stack2.peek() == left) {//如果是从左子节点返回父节点，则将标记改为右子节点
                stack2.pop();
                stack2.push(right);
                root = stack.peek().right;
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(postorderTraversal1(root.left));
        list.addAll(postorderTraversal1(root.right));
        list.add(root.val);
        return list;
    }
}
