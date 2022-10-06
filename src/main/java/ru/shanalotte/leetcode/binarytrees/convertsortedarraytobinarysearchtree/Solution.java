package ru.shanalotte.leetcode.binarytrees.convertsortedarraytobinarysearchtree;

import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return make(nums, 0, nums.length - 1);
  }

  private TreeNode make(int[] arr, int a, int b) {
    if (a > b) {
      return null;
    }
    TreeNode result = new TreeNode();
    int middle = (a + b) / 2;
    result.val = arr[middle];
    result.left = make(arr, a, middle - 1);
    result.right = make(arr, middle + 1, b);
    return result;
  }
}