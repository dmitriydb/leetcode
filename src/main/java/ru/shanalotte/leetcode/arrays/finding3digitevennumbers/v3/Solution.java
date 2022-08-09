package ru.shanalotte.leetcode.arrays.finding3digitevennumbers.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 2, 8, 8, 2})));
  }

  public int[] findEvenNumbers(int[] digits) {
    int[] digitOccurences = new int[10];
    List<Integer> result = new ArrayList<>();
    for (int digit : digits) {
      digitOccurences[digit]++;
    }
    for (int number = 100; number < 999; number += 2) {
      int firstDigit = number / 100;
      int secondDigit = (number % 100) / 10;
      int thirdDigit = number % 10;
      digitOccurences[firstDigit]--;
      digitOccurences[secondDigit]--;
      digitOccurences[thirdDigit]--;
      if (digitOccurences[firstDigit] >= 0 && digitOccurences[secondDigit] >= 0 && digitOccurences[thirdDigit] >= 0) {
        result.add(number);
      }
      digitOccurences[firstDigit]++;
      digitOccurences[secondDigit]++;
      digitOccurences[thirdDigit]++;
    }
    return result.stream().mapToInt(e -> e).toArray();
  }
}
