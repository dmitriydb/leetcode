package ru.shanalotte.leetcode.binarytrees.convertsortedarraytobinarysearchtree;

import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return node(nums, 0, nums.length - 1);
  }

  private TreeNode node(int[] arr, int a, int b) {
    if (a > b) {
      return null;
    }
    TreeNode result = new TreeNode();
    int middle = (a + b) / 2;
    result.val = arr[middle];
    result.left = node(arr, a, middle - 1);
    result.right = node(arr, middle + 1, b);
    return result;
  }
}