package ru.shanalotte.leetcode.binarytrees.minimumdistancebetweenbstnodes.v3;

import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {

  int result = Integer.MAX_VALUE;
  Integer lastVisitedNodeValue = null;

  public int minDiffInBST(TreeNode root) {
    visit(root);
    return result;
  }

  private void visit(TreeNode root) {
    if (root == null) {
      return;
    }
    visit(root.left);
    if (lastVisitedNodeValue != null) {
      int diff = Math.abs(lastVisitedNodeValue - root.val);
      result = Math.min(result, diff);
    }
    lastVisitedNodeValue = root.val;
    visit(root.right);
  }

}