package ru.shanalotte.leetcode.misc.pascalstriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> getRow(int rowIndex) {
      if (rowIndex == 0) {
        return List.of(1);
      }
      if (rowIndex == 1) {
        return List.of(1, 1);
      }
      List<Integer> result = new ArrayList<>();
      result.add(1);
      result.add(2);
      int currentRow = 2;
      while (currentRow < rowIndex) {
        int last = 1;
        for (int i = 1; i < result.size(); i++) {
          int newVal = result.get(i) + last;
          last = result.get(i);
          result.set(i, newVal);
        }
        result.add(last + 1);
        currentRow++;
      }
      result.add(1);
      return result;
  }
}
