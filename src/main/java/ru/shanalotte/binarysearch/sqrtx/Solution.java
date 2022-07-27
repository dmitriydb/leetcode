package ru.shanalotte.binarysearch.sqrtx;

class Solution {

  public int mySqrt(int x) {
    long leftBound = 0;
    long rightBound = x;
    while (leftBound < rightBound) {
      long middle = (leftBound + rightBound) / 2;
      if (middle * middle <= x) {
        leftBound = middle + 1;
      } else {
        rightBound = middle - 1;
      }
    }
    return leftBound * leftBound > x ? (int)(leftBound - 1) : (int)leftBound;
  }

}