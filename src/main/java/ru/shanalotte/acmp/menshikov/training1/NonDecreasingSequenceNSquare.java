package ru.shanalotte.acmp.menshikov.training1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NonDecreasingSequenceNSquare {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();
    int[] numbers = new int[n];
    int[] dp = new int[n];
    int max = 0;
    readNumbersFromConsole(in, n, numbers);
    max = calculateMaxLISLength(n, numbers, dp, max);
    int cmax = max;
    List<Integer> arr = new ArrayList<>();
    for (int i = n - 1; i >= 0; i--) {
      if (dp[i] == max) {
        arr.add(numbers[i]);
        max--;
      }
    }
    out.println(cmax);
    Collections.reverse(arr);
    for (int a : arr) {
      out.print(a + " ");
    }
    in.close();
    out.flush();
    out.close();
  }

  private static int calculateMaxLISLength(int n, int[] numbers, int[] dp, int max) {
    for (int i = 0; i < n; i++) {
      int localMax = 0;
      for (int j = 0; j < i; j++) {
        if (numbers[j] < numbers[i]) {
          if (dp[j] > localMax) {
            localMax = dp[j];
          }
        }
      }
      dp[i] = localMax + 1;
      if (max < dp[i]) {
        max = dp[i];
      }
    }
    return max;
  }

  private static void readNumbersFromConsole(Scanner in, int n, int[] numbers) {
    for (int i = 0; i < n; i++) {
      numbers[i] = in.nextInt();
    }
  }

}
