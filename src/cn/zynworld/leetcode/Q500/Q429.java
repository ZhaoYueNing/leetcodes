package cn.zynworld.leetcode.Q500;

import cn.zynworld.leetcode.common.Node;

import java.util.*;

/**
 * @author zhaoyuening
 */
public class Q429 {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) return resultList;

        List<Integer> currentNodes = new ArrayList<Integer>();

        final LinkedList<Node> nodeQueue = new LinkedList<Node>();
        // 记录该层的最后一个元素
        Node lastNode = root;
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node node = nodeQueue.poll();
            currentNodes.add(node.val);
            // 遍历子接点
            if (node.children != null) node.children.forEach(cNode -> nodeQueue.add(cNode));
            if (node == lastNode) {
                resultList.add(currentNodes);
                currentNodes = new ArrayList<>();
                if (!nodeQueue.isEmpty()) lastNode = nodeQueue.getLast();
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        Node root = new Node(1, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());

        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        node3.children.add(node5);
        node3.children.add(node6);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }
}
