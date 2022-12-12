package ru.shanalotte.leetcode.binarytrees.deepestleavessum;


import ru.shanalotte.leetcode.utils.TreeNode;

public class Solution {

  private int maxDepth = 0;
  private int sum = 0;

  public int deepestLeavesSum(TreeNode root) {
    traverse(root, 1);
    return sum;
  }

  private void traverse(TreeNode root, int currentDepth) {
    if (root == null) {
      return;
    }
    if (currentDepth > maxDepth) {
      sum = root.val;
      maxDepth = currentDepth;
    } else if (currentDepth == maxDepth) {
      sum += root.val;
    }
    traverse(root.left,currentDepth+1);
    traverse(root.right,currentDepth+1);
  }
}