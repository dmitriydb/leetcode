package ru.shanalotte.leetcode.binarytrees.minimumdistancebetweenbstnodes.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {

  public int minDiffInBST(TreeNode root) {
    List<TreeNode> all = new ArrayList<>();
    check(root, all);
    all.sort(Comparator.comparingInt(n -> n.val));
    int min = Integer.MAX_VALUE;
    for (int i = 1; i < all.size(); i++) {
      if (Math.abs(all.get(i).val - all.get(i - 1).val) < min) {
        min = Math.abs(all.get(i).val - all.get(i - 1).val);
      }
    }
    return min;
  }

  private void check(TreeNode root, List<TreeNode> all) {
    if (root != null) {
      all.add(root);
      check(root.left, all);
      check(root.right, all);
    }

  }


}