package ru.shanalotte.leetcode.binarytrees.diameterofbinarytree;


import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {

  private int result = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return result;
  }

  public int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = 1 + depth(node.left);
    int right = 1 + depth(node.right);
    int max = Math.max(left, right);
    if (left + right - 2 > result) {
      result = left + right - 2;
    }
    return max;
  }
}