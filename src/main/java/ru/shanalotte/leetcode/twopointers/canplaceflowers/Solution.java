package ru.shanalotte.leetcode.twopointers.canplaceflowers;

class Solution {

  private boolean canPlant(int position, int[] flowerbed) {
    if (flowerbed[position] == 1) {
      return false;
    }
    int left = position == 0 ? 0 : flowerbed[position - 1];
    int right = position == flowerbed.length - 1 ? 0 : flowerbed[position + 1];
    return (left == 0 && right == 0);
  }

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int n1 = n;
    int n2 = n;
    int p1 = 0;
    int p2 = 1;
    while (p1 < flowerbed.length || p2 < flowerbed.length) {
      if (p1 < flowerbed.length) {
        if (canPlant(p1, flowerbed)) {
          n1--;
        }
        p1 += 2;
      }
      if (p2 < flowerbed.length) {
        if (canPlant(p2, flowerbed)) {
          n2--;
        }
        p2 += 2;
      }
    }
    return (n1 <= 0 || n2 <= 0);
  }

}