package cn.zynworld.leetcode.common;

/**
 * @author zhaoyuening
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode buildByArr(int[] arr) {
        ListNode firstNode = new ListNode(0);
        ListNode curNode = firstNode;
        for (int n : arr) {
            curNode.next = new ListNode(n);
            curNode = curNode.next;
        }

        return firstNode.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
