package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/*
@see https://acmp.ru/index.asp?main=task&id_task=798
 */
public class Problem0798 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    int m = in.nextInt();
    int n = in.nextInt();
    int i = in.nextInt();
    int j = in.nextInt();
    int c = in.nextInt();
    if (isEvenNumber(m * n)) {
      out.println("equal");
    } else {
       if (isEvenNumber(i + j)) {
         out.println(nameOfColor(c));
       } else {
         out.println(nameOfColor(inverseColor(c)));
       }
    }
    out.close();
  }

  private static int inverseColor(int color) {
    return color == 0 ? 1 : 0;
  }

  private static boolean isEvenNumber(int number) {
    return number % 2 == 0;
  }

  private static String nameOfColor(int color) {
    return switch (color) {
      case 0 -> "black";
      case 1 -> "white";
      default -> throw new IllegalStateException("Unexpected value: " + color);
    };
  }

}
