package ru.shanalotte.leetcode.arrays.finding3digitevennumbers.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {
  public int[] findEvenNumbers(int[] digits) {
    List<Integer> result = new ArrayList<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int digit : digits) {
      map.merge(digit, 1, Integer::sum);
    }
    for (int firstDigit : map.keySet()) {
      if (firstDigit == 0) {
        continue;
      }
      map.put(firstDigit, map.get(firstDigit) - 1);
      constructNumberFor(firstDigit * 100, 1, result, map);
      map.put(firstDigit, map.get(firstDigit) + 1);
    }
    return result.stream().mapToInt(e -> e).toArray();
  }

  private void constructNumberFor(int number, int step, List<Integer> result, TreeMap<Integer, Integer> map) {
    if (step == 1) {
      for (int secondDigit : map.keySet()) {
        if (map.get(secondDigit) == 0) {
          continue;
        }
        map.put(secondDigit, map.get(secondDigit) - 1);
        constructNumberFor(number + secondDigit * 10, 2, result, map);
        map.put(secondDigit, map.get(secondDigit) + 1);
      }
    } else if (step == 2) {
      for (int thirdDigit : map.keySet()) {
        if (thirdDigit % 2 != 0 || map.get(thirdDigit) == 0) {
          continue;

        }
        result.add(number + thirdDigit);
      }
    }
}
    public static void main (String[]args){
      System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 1, 3, 0})));
    }

  }
