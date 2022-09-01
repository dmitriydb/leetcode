package ru.shanalotte.leetcode.bitoperations.complementofbase10integer;

public class Solution {

  public int bitwiseComplement(int n) {
    if (n == 0) {
      return 1;
    }
    int bitCount = log2(n);
    n = -n - 1;
    int bitMask = bitMask(bitCount);
    return bitMask & n;
  }

  public int bitMask(int size) {
    return Integer.MAX_VALUE >> (32 - size - 1);
  }

  public int log2(int n) {
    return (int) (Math.log(n) / Math.log(2));
  }

}
