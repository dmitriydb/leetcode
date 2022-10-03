package ru.shanalotte.leetcode.binarytrees.binarytreetilt;

import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {

  private int result = 0;

  public int findTilt(TreeNode root) {
    process(root);
    return result;
  }

  public int process(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int leftSum = process(node.left);
    int rightSum = process(node.right);
    result += Math.abs(leftSum - rightSum);
    return leftSum + rightSum + node.val;
  }


}