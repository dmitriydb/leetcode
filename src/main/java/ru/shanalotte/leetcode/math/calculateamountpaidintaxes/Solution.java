package ru.shanalotte.leetcode.math.calculateamountpaidintaxes;

public class Solution {

  public double calculateTax(int[][] brackets, int income) {
    double taxes = 0;
    int nextBracket = 0;
    while (income > 0) {
      int nextBracketIncome = nextBracket == 0 ? brackets[nextBracket][0] : brackets[nextBracket][0] - brackets[nextBracket - 1][0];
      int localIncome = Math.min(income, nextBracketIncome);
      taxes += (localIncome * brackets[nextBracket][1] / 100.0d);
      nextBracket++;
      income -= localIncome;
    }
    return taxes;
  }

}
