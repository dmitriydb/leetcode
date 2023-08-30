package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem688 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    double rX = in.nextInt();
    double rY = in.nextInt();
    in.nextLine();
    double dX = in.nextInt();
    double dY = in.nextInt();
    in.nextLine();
    int holesCount = in.nextInt();
    in.nextLine();
    boolean holeFound = false;
    for (int i = 1; i <= holesCount; i++) {
      double holeX = in.nextInt();
      double holeY = in.nextInt();
      double rabbitDistance = distance(rX, rY, holeX, holeY);
      double dogDistance = distance(dX, dY, holeX, holeY);
      if (rabbitDistance * 2 <= dogDistance) {
        out.println(i);
        holeFound = true;
        break;
      }
      in.nextLine();
    }
    if (!holeFound) {
      out.println("NO");
    }
    in.close();
    out.close();
  }

  public static double distance(double x, double y, double x1, double y1) {
    return Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
  }

}
