package ru.shanalotte.leetcode.binarytrees.minimumdistancebetweenbstnodes.v2;

import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {

  int result = Integer.MAX_VALUE;

  public int minDiffInBST(TreeNode root) {
    check(root);
    return result;
  }

  private void check(TreeNode root) {
    int max = root.left == null ? Integer.MAX_VALUE : max(root.left);
    int min = root.right == null ? Integer.MAX_VALUE : min(root.right);
    if (Math.abs(root.val - max) < result) {
      result = Math.abs(root.val - max);
    }
    if (Math.abs(root.val - min) < result) {
      result = Math.abs(root.val - min);
    }
    if (root.left != null) {
      check (root.left);
    }
    if (root.right != null) {
      check (root.right);
    }
  }

  private int min(TreeNode node) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }
    int current = node.val;
    int left = min(node.left);
    int right = min(node.right);
    return Math.min(Math.min(current, left), Math.min(left, right));
  }

  private int max(TreeNode node) {
    if (node == null) {
      return Integer.MIN_VALUE;
    }
    int current = node.val;
    int left = max(node.left);
    int right = max(node.right);
    return Math.max(Math.max(current, left), Math.max(left, right));
  }

}