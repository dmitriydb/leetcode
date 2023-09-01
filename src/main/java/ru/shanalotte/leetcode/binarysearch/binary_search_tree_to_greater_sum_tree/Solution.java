package ru.shanalotte.leetcode.binarysearch.binary_search_tree_to_greater_sum_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import com.sun.source.tree.Tree;
import ru.shanalotte.leetcode.utils.TreeNode;

public class Solution {

  public int sum = 0;

  public TreeNode bstToGst(TreeNode root) {
    visit(root);
    return root;
  }

  public void visit(TreeNode node) {
    if (node == null) {
      return;
    }
    visit(node.right);
    sum += node.val;
    node.val = sum;
    visit(node.left);
  }

}
