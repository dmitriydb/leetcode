package ru.shanalotte.leetcode.arrays.timeneededtobuytickets;

class Solution {
  public int timeRequiredToBuy(int[] tickets, int k) {
    int ticketsToBuy = tickets[k];
    int timeTaken = ticketsToBuy;
    for (int i = 0; i < tickets.length; i++) {
      if (i == k) {
        continue;
      }
      if (i < k) {
        timeTaken += Math.min(tickets[i], ticketsToBuy);
      }
      if (i > k) {
        timeTaken += tickets[i] >= ticketsToBuy ? ticketsToBuy - 1 : tickets[i];
      }
    }
    return timeTaken;
  }
}