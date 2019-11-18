package cn.zynworld.leetcode.q100;

import cn.zynworld.leetcode.common.ListNode;

/**
 * @author zhaoyuening
 *
 */
public class Q23 {

    /**
     * 暴力方式
     */
    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode firstNode = new ListNode(0);
        ListNode currentNode = firstNode;

        while (true) {
            Integer minNodeIndex = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null && (minNodeIndex == null || node.val < lists[minNodeIndex].val)) {
                    minNodeIndex = i;
                }
            }

            if (minNodeIndex == null) {
                break;
            }

            currentNode.next = lists[minNodeIndex];
            currentNode = currentNode.next;
            lists[minNodeIndex] = lists[minNodeIndex].next;
        }

        return firstNode.next;
    }


    /**
     * 归并方式
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsByMerger(lists, 0, lists.length);
    }

    public static ListNode mergeKListsByMerger(ListNode[] lists, Integer startIndex, Integer endIndex) {
        // 为空情况
        if (endIndex - startIndex < 1) {
            return null;
        }

        // 只有一个链表直接返回
        if (endIndex - startIndex == 1) {
            return lists[startIndex];
        }

        // 归并左右的中间下标
        Integer mid = (endIndex - startIndex) / 2 + startIndex;

        // 头部哨兵节点
        ListNode resultFirstNode = new ListNode(0);
        ListNode curNode = resultFirstNode;

        // 计算出左右节点链表
        ListNode leftNode = mergeKListsByMerger(lists, startIndex, mid);
        ListNode rightNode = mergeKListsByMerger(lists, mid, endIndex);

        // 对左右链表合并
        while (leftNode != null && rightNode != null) {
            // 得到两个头中的最大节点
            int maxHead = Math.max(leftNode.val, rightNode.val);
            // 将左侧链表中小于最大节点的所有节点接入
            while (leftNode != null && leftNode.val < maxHead) {
                curNode.next = leftNode;
                curNode = curNode.next;

                leftNode = leftNode.next;
            }

            // 将右侧链表中小于等于最大头节点的节点接入
            while (rightNode != null && rightNode.val <= maxHead) {
                curNode.next = rightNode;
                curNode = curNode.next;

                rightNode = rightNode.next;
            }
        }

        // 将剩余未接入的全部接入
        if (leftNode != null) curNode.next = leftNode;
        if (rightNode != null) curNode.next = rightNode;

        return resultFirstNode.next;
    }

    public static void main(String[] args) {
        int[][] testData = new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] nodes = getTestListNodes(testData);
        ListNode listNode = mergeKLists(nodes);
        System.out.println(listNode);
    }

    public static ListNode[] getTestListNodes(int[][] testData) {
        ListNode[] nodes = new ListNode[testData.length];
        for (int i = 0; i < testData.length; i++) {
            ListNode firstNode = new ListNode(0);
            ListNode curNode = firstNode;
            for (int n : testData[i]) {
                curNode.next = new ListNode(n);
                curNode = curNode.next;
            }
            nodes[i] = firstNode.next;
        }

        return nodes;
    }
}
