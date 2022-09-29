package ru.shanalotte.leetcode.combinatorics.primearrangements;

public class Solution {

  public int numPrimeArrangements(int n) {
    int m = 0;
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        m++;
      }
    }
    n = n - m;
    long result = 1;
    for (int i = 1; i <= m; i++) {
      result = (result * i) % 1000000007 ;
    }
    for (int i = 1; i <= n; i++) {
      result = (result * i) % 1000000007 ;
    }
    return (int) result;
  }

  private boolean isPrime(int n) {
    if (n == 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


}
