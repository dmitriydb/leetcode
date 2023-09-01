package ru.shanalotte.leetcode.linkedlists.insert_greatest_common_divisors_in_linked_list;


import ru.shanalotte.leetcode.utils.ListNode;

public class Solution {

  public ListNode insertGreatestCommonDivisors(ListNode head) {
    insertInto(head);
    return head;
  }

  private void insertInto(ListNode head) {
    if (head.next == null) {
      return;
    }
    ListNode temp = head.next;
    head.next = new ListNode(gcd(head.val, head.next.val));
    head.next.next = temp;
    insertInto(temp);
  }

  private int gcd(int a, int b) {
    if (a < b) {
      return gcd(b, a);
    }
    if (b == 0) {
      return a;
    }
    return gcd (a % b, b);
  }

}