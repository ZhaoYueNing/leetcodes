package cn.zynworld.leetcode.common;

import java.util.List;

/**
 * @author zhaoyuening
 */
public class Node {
    public Integer val;
    public List<Node> children;

    public Node() {}

    public Node(Integer val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
