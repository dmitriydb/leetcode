package ru.shanalotte.leetcode.misc.groupthepeople;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> answer = new ArrayList<>();
    ArrayList<Integer>[] array = new ArrayList[500];
    for (int i = 0; i < groupSizes.length; i++) {
      int groupNumber = groupSizes[i];
      if (array[groupNumber] == null) {
        array[groupNumber] = new ArrayList<>();
      }
      var group = array[groupNumber];
      if (group.size() < groupNumber) {
        group.add(i);
      }
      if (group.size() == groupNumber) {
        answer.add(group);
        array[groupNumber] = new ArrayList<>();
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().groupThePeople(new int[]{3,3,3,3,3,1,3}));
  }
}
