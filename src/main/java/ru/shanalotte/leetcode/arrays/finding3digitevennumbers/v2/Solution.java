package ru.shanalotte.leetcode.arrays.finding3digitevennumbers.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new Solution().findEvenNumbers(new int[]{2, 2, 8, 8, 2})));
  }

  public int[] findEvenNumbers(int[] digits) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    for (int digit : digits) {
      map.merge(digit, 1, Integer::sum);
    }
    for (int i = 100; i < 999; i += 2) {
      int a1 = i / 100;
      int a2 = (i % 100) / 10;
      int a3 = i % 10;
      int n1 = a1;
      int n2 = -1;
      int n3 = -1;
      int q1 = 1;
      int q2 = 0;
      int q3 = 0;
      if (a2 == a1) {
        q1++;
      } else {
        q2 = 1;
        n2 = a2;
      }
      if (a3 == a2 && a3 != a1) {
        q2++;
      } else if (a3 == a1) {
        q1++;
      } else {
        q3 = 1;
        n3 = a3;
      }
      if (map.get(n1) == null || map.get(n1) < q1) {
        continue;
      }
      if (n2 != -1 && (map.get(n2) == null || map.get(n2) < q2)) {
        continue;
      }
      if (n3 != -1 && (map.get(n3) == null || map.get(n3) < q3)) {
        continue;
      }
      result.add(i);
    }
    return result.stream().mapToInt(e -> e).toArray();
  }
}
