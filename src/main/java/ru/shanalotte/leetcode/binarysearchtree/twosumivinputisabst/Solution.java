package ru.shanalotte.leetcode.binarysearchtree.twosumivinputisabst;

import java.util.HashSet;
import java.util.Set;
import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {

  public boolean findTarget(TreeNode root, int k) {
    Set<Integer> searchingNumbers = new HashSet<>();
    searchingNumbers.add(k - root.val);
    return check(root.left, k, searchingNumbers) || check(root.right, k, searchingNumbers);
  }

  public boolean check(TreeNode node, int target, Set<Integer> desiredNumbers) {
    if (node == null) {
      return false;
    }
    if (desiredNumbers.contains(node.val)) {
      return true;
    }
    desiredNumbers.add(target - node.val);
    return check(node.left, target, desiredNumbers) || check(node.right, target, desiredNumbers);
  }
}