package ru.shanalotte.leetcode.binarytrees.deepestleavessum;

import java.util.LinkedList;
import java.util.Queue;
import ru.shanalotte.leetcode.utils.TreeNode;

public class Solutionv2 {

  static class RootPair {
    TreeNode node;
    int depth;

    public RootPair(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }

    static RootPair of(TreeNode node, int depth) {
      return new RootPair(node, depth);
    }
  }

  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    int maxDepth = 0;
    Queue<RootPair> pairs = new LinkedList<>();
    pairs.offer(RootPair.of(root, 1));
    while (!pairs.isEmpty()) {
      RootPair next = pairs.poll();
      if (next.depth > maxDepth) {
        maxDepth = next.depth;
        sum = next.node.val;
      } else if (next.depth == maxDepth) {
        sum += next.node.val;
      }
      if (next.node.left != null) {
        pairs.offer(RootPair.of(next.node.left, next.depth + 1));
      }
      if (next.node.right != null) {
        pairs.offer(RootPair.of(next.node.right, next.depth + 1));
      }
    }
    return sum;
  }


}