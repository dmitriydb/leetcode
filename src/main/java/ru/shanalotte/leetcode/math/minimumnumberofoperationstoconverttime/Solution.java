package ru.shanalotte.leetcode.math.minimumnumberofoperationstoconverttime;

public class Solution {

  public int convertTime(String current, String correct) {
    int a = extractTime(current);
    int b = extractTime(correct);
    TimeStatus ts = new TimeStatus(a, b);
    while (ts.a < ts.b) {
      int delta = ts.b - ts.a;
      if (delta >= 60) {
        ts.stepOver(60);
      } else if (delta >= 15) {
        ts.stepOver(15);
      } else if (delta >= 5) {
        ts.stepOver(5);
      } else {
        ts.stepOver(1);
      }
    }
    return ts.steps;
  }

  private int extractTime(String current) {
    int h1 = Integer.parseInt(current.substring(0, 2));
    int m1 = Integer.parseInt(current.substring(3, 5));
    return h1 * 60 + m1;
  }

  private class TimeStatus {
    private int a;
    private int b;
    private int steps;
    public TimeStatus(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public void stepOver(int minutes) {
      int c = (b - a) / minutes;
      steps += c;
      a += c * minutes;
    }

  }

}
