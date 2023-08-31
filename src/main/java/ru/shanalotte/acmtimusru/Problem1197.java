package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem1197 {
  public static void main(String[] args) {
    int arr[] = {2, 3, 4, 4, 4, 4, 3, 2, 3, 4, 6, 6, 6, 6, 4, 3, 4, 6, 8, 8, 8, 8, 6, 4, 4, 6, 8, 8, 8, 8, 6, 4, 4, 6, 8, 8, 8, 8, 6, 4, 4, 6, 8, 8, 8, 8, 6, 4, 3, 4, 6, 6, 6, 6, 4, 3, 2, 3, 4, 4, 4, 4, 3, 2};
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();
    in.nextLine();
    for (int i = 0; i < n; i++) {
      String line = in.nextLine();
      int x = line.charAt(0) - 'a';
      int y = line.charAt(1) - '1';
      out.println(arr[x * 8 + y]);
    }
    in.close();
    out.close();
  }

}