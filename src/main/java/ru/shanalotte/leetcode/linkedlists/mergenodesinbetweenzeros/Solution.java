package ru.shanalotte.leetcode.linkedlists.mergenodesinbetweenzeros;

import ru.shanalotte.leetcode.utils.ListNode;

class Solution {

  public ListNode mergeNodes(ListNode head) {
    ListNode result = head.next;
    ListNode next = result;
    ListNode p1 = head.next;
    ListNode p2 = p1.next;
    while (p1 != null) {
      while (p2.val != 0) {
        p1.val += p2.val;
        p2 = p2.next;
      }
      next.next = p1;
      next = next.next;
      p1 = p2.next;
      if (p1 != null && p1.next != null) {
        p2 = p1.next;
      }
    }
    next.next = null;
    return result;
  }

}