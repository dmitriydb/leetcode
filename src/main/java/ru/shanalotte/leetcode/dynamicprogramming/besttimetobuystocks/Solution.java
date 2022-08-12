package ru.shanalotte.leetcode.dynamicprogramming.besttimetobuystocks;

class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int currentProfit = 0;
    int currentMinPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] >= currentMinPrice) {
        currentProfit = prices[i] - currentMinPrice;
        if (currentProfit > maxProfit) {
          maxProfit = currentProfit;
        }
      } else {
        currentMinPrice = prices[i];
      }
    }
    if (currentProfit > maxProfit) {
      maxProfit = currentProfit;
    }
    return maxProfit;
  }
}