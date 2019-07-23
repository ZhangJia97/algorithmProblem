package LeetCode;

import LeetCode.comm.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangjia
 * @title: Q199_二叉树的右视图
 * @date 2019-05-02 13:57
 */
public class Q199_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = root;
        queue.offer(root);
        int size = 1;
        while(!queue.isEmpty()){
            size = queue.size();
            int val = 0;
            while(size != 0){
                tmp = queue.poll();
                val = tmp.val;
                size--;
                if(tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
            }
            list.add(val);
        }
        return list;
    }
}
