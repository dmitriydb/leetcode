package ru.shanalotte.leetcode.linkedlists.intersectionoftwolinkedlists;

import ru.shanalotte.leetcode.utils.ListNode;

public class Solution {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode result = null;
    markList(headA);
    result = findFirstMarkedNode(headB);
    resetList(headA);
    return result;
  }

  private ListNode findFirstMarkedNode(ListNode head) {
    ListNode result = null;
    while (head != null) {
      if (head.val < 0) {
        if (result == null) {
          result = head;
        }
        head.val = -head.val;
      }
      head = head.next;
    }
    return result;
  }

  private void resetList(ListNode headA) {
    ListNode p1;
    p1 = headA;
    while (p1 != null) {
      if (p1.val < 0) {
        p1.val = -p1.val;
      }
      p1 = p1.next;
    }
  }

  private void markList(ListNode headA) {
    ListNode p1 = headA;
    do {
      p1.val = -p1.val;
      p1 = p1.next;
    } while (p1 != null);
  }

}