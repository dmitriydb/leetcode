package ru.shanalotte.leetcode.binarytrees.cousinginbinarytree;

import ru.shanalotte.leetcode.utils.TreeNode;

public class Solution {

  private int firstFoundDepth = -1;
  private int firstFoundParent = -1;
  private boolean result = false;

  public boolean isCousins(TreeNode root, int x, int y) {
    check(root.left, x, y, 1, root.val);
    check(root.right, x, y, 1, root.val);
    return result;
  }

  public void check (TreeNode node, int x, int y, int depth, int parentVal) {
    if (node == null) {
      return;
    }
    if (node.val == x || node.val == y) {
      if (firstFoundDepth == -1) {
        firstFoundDepth = depth;
        firstFoundParent = parentVal;
      } else {
        if (firstFoundDepth == depth && parentVal != firstFoundParent) {
          result = true;
        }
      }
    }
    check(node.left, x, y, depth + 1, node.val);
    check(node.right, x, y, depth + 1, node.val);
  }


}
