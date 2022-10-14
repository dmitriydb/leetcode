package ru.shanalotte.leetcode.bitoperations.reversebits;

public class Solution {


  int bit(int number, int position) {
    return (number >> position) % 2 == 0 ? 0 : 1;
  }

  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      int bit = bit(n, i);
      int mask = (bit << (31 - i));
      result = result | mask;
    }
    return (int) result;
  }

  public static void main(String[] args) {
    int x = new Solution().reverseBits(-3);
    String r = Integer.toBinaryString(x);
    while (r.length() < 32) {
      r = '0' + r;
    }
    System.out.println(r);
  }

}
