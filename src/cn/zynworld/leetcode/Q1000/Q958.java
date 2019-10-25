package cn.zynworld.leetcode.Q1000;

import cn.zynworld.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhaoyuening
 */
public class Q958 {
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        boolean hasNull = false;
        // 按层遍历
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (node == null) {
                hasNull = true;
                continue;
            }

            if (hasNull) {
                return false;
            }

            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }

        return true;
    }

    public static void main(String[] args) {
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(null);
        System.out.println(nodeQueue);
    }
}
