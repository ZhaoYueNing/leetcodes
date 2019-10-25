package cn.zynworld.leetcode.q200;

import cn.zynworld.leetcode.common.TreeNode;

/**
 * @author zhaoyuening
 */
public class Q200 {
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;

        flatten(left);
        flatten(right);

        root.right = left;
        if (root.right == null) {
            root.right = right;
            return;
        }

        TreeNode node = left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);
        System.out.println(root);
    }
}
