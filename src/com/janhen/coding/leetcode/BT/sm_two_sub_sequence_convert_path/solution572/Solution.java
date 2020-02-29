package com.janhen.leetcode.BT.sm_two_sub_sequence_convert_path.solution572;

import com.janhen.leetcode.structures.TreeNode;

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
        if (s.val == t.val)
            if (isSame(s, t))
                return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);   // is traverse, no constrict
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)      // strict define
            return false;
        if (t1.val != t2.val)
            return false;
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}