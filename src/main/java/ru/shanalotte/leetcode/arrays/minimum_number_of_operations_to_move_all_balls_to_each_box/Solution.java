package ru.shanalotte.leetcode.arrays.minimum_number_of_operations_to_move_all_balls_to_each_box;

import java.util.Arrays;
import ru.shanalotte.leetcode.utils.TreeNode;

public class Solution {

  public int[] minOperations(String boxes) {
    int[] answer = new int[boxes.length()];
    int distanceFrom0 = 0;
    int totalBalls = 0;
    for (int i = 0; i < boxes.length(); i++) {
      if (boxes.charAt(i) == '1') {
        distanceFrom0 += i;
        totalBalls++;
      }
    }
    int meetedBalls = 0;
    for (int i = 0; i < boxes.length(); i++) {
      answer[i] = distanceFrom0;
      if (boxes.charAt(i) == '1') {
        meetedBalls++;
        totalBalls--;
      }
      distanceFrom0 = distanceFrom0 - totalBalls + meetedBalls;
    }
    return answer;
  }

}
