package ru.shanalotte.leetcode.linkedlistcycle;

import ru.shanalotte.leetcode.utils.ListNode;

public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode pointer1 = head;
    ListNode pointer2 = head.next;
    while (true) {
      if (pointer1 == null) {
        return false;
      }
      pointer1 = pointer1.next;
      if (pointer2 == null || pointer2.next == null) {
        return false;
      }
      pointer2 = pointer2.next.next;
      if (pointer1 == pointer2) {
        return true;
      }
    }
  }
}
