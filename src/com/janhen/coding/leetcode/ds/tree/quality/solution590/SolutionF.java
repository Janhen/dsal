package com.janhen.coding.leetcode.ds.tree.quality.solution590;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SolutionF {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        // LRD -> DRL reverse
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);

            for (Node node : root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}
