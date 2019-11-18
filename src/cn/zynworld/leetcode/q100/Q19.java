package cn.zynworld.leetcode.q100;

import cn.zynworld.leetcode.common.ListNode;

/**
 * @author zhaoyuening
 */
public class Q19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置哨兵节点
        ListNode firstNode = new ListNode(-1);
        firstNode.next = head;
        // 删除倒数位置接点
        deleteByPosition(firstNode,n);
        return firstNode.next;
    }

    private static Integer deleteByPosition(ListNode node,Integer deletePosition) {
        if (node == null) {
            return 0;
        }

        Integer curPosition = deleteByPosition(node.next, deletePosition) + 1;
        if (curPosition == deletePosition + 1 && node.next != null) {
            node.next = node.next.next;
        }

        return curPosition;
    }
}
