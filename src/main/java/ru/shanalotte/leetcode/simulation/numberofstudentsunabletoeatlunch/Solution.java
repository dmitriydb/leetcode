package ru.shanalotte.leetcode.simulation.numberofstudentsunabletoeatlunch;

public class Solution {

  public int countStudents(int[] students, int[] sandwiches) {
    int currentSandwichIndex = 0;
    boolean sandwichWasDispensed = false;
    int left = students.length;
    do {
      sandwichWasDispensed = false;
      for (int i = 0; i < students.length; i++) {
        if (students[i] == -1) {
          continue;
        }
        if (students[i] == sandwiches[currentSandwichIndex]) {
          currentSandwichIndex++;
          students[i] = -1;
          sandwichWasDispensed = true;
          left--;
        }
      }
    } while (sandwichWasDispensed);
    return left;
  }

}
