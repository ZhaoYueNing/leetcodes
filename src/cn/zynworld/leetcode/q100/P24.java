package cn.zynworld.leetcode.q100;

import cn.zynworld.leetcode.common.ListNode;

/**
 * @author zhaoyuening
 *
 */
public class P24 {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = new ListNode(0);

        ListNode prevNode = firstNode;
        ListNode node = head;

        while (node != null && node.next != null) {
            ListNode leftNode = node;
            ListNode rightNode = node.next;

            node = rightNode.next;
            prevNode.next = rightNode;
            prevNode = leftNode;

            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
        }

        return firstNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.buildByArr(new int[]{1, 2, 3, 4});

        ListNode reuslt = swapPairs(listNode);
        System.out.println(reuslt);
    }
}
