package ru.shanalotte.leetcode.simulation.distributecandiestopeople;

public class Solution {

  public int[] distributeCandies(int candies, int num_people) {
    int[] result = new int[num_people];
    int current = 1;
    int pos = 0;
    while (candies > 0) {
      if (candies >= current) {
        result[pos] += current;
        candies -= current;
        current++;
        pos++;
        if (pos >= num_people) {
          pos = 0;
        }
      } else {
        result[pos] += candies;
        candies = 0;
      }
    }
    return result;
  }

}
