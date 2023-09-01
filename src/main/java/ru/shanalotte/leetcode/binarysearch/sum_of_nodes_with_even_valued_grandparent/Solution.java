package ru.shanalotte.leetcode.binarysearch.sum_of_nodes_with_even_valued_grandparent;

import ru.shanalotte.leetcode.utils.TreeNode;

public class Solution {

  public int sumEvenGrandparent(TreeNode root) {
    return sumOf(root);
  }

  public int sumOf(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int localSum = 0;
    if (root.val % 2 == 0) {
      if (root.right != null && root.right.right != null) {
        localSum += root.right.right.val;
      }
      if (root.right != null && root.right.left != null) {
        localSum += root.right.left.val;
      }
      if (root.left != null && root.left.left != null) {
        localSum += root.left.left.val;
      }
      if (root.left != null && root.left.right != null) {
        localSum += root.left.right.val;
      }
    }
    return localSum + sumOf(root.left) + sumOf(root.right);
  }

}
