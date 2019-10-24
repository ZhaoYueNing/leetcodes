package cn.zynworld.leetcode.Q1000;

import cn.zynworld.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhaoyuening
 * @date 2019/10/21.
 */
public class Q958 {

	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
		treeNodeQueue.add(root);
		boolean hasNull = false;
		while (!treeNodeQueue.isEmpty()) {
			TreeNode node = treeNodeQueue.poll();
			if (node.left == null && node.right != null) {
				return false;
			}

			if (node.left != null) {
				treeNodeQueue.add(node.left);
			} else {
				hasNull = true;
			}
			if (node.right != null) {
				treeNodeQueue.add(node.right);
			}
		}

		return true;
	}

}
