package ru.shanalotte.leetcode.bfs.secondminimumnodeinabinarytree;

import java.util.LinkedList;
import java.util.Queue;
import ru.shanalotte.leetcode.utils.TreeNode;

class Solution {

  public int findSecondMinimumValue(TreeNode root) {
    int min = root.val;
    int secondMin = Integer.MAX_VALUE;
    boolean wasFound = false;
    Queue<TreeNode> queue = new LinkedList<>();
    addChildsIfPresent(root, queue);
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; i++) {
        TreeNode node = queue.poll();
        if (node.val > min && node.val <= secondMin) {
          secondMin = node.val;
          wasFound = true;
        }
        addChildsIfPresent(node, queue);
      }
    }
    if (!wasFound) {
      return -1;
    }
    return secondMin;
  }

  private void addChildsIfPresent(TreeNode root, Queue<TreeNode> queue) {
    addNodeIfPresent(queue, root.left);
    addNodeIfPresent(queue, root.right);
  }

  private void addNodeIfPresent(Queue<TreeNode> queue, TreeNode node) {
    if (node != null) {
      queue.offer(node);
    }
  }

}