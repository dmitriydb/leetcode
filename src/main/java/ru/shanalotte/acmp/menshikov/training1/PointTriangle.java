package ru.shanalotte.acmp.menshikov.training1;

import java.io.PrintWriter;
import java.util.Scanner;

public class PointTriangle {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    double x1 = in.nextDouble();
    double y1 = in.nextDouble();
    double x2 = in.nextDouble();
    double y2 = in.nextDouble();
    double x3 = in.nextDouble();
    double y3 = in.nextDouble();
    double x = in.nextDouble();
    double y = in.nextDouble();

    boolean s1 = sign(x1, y1, x2, y2, x, y) > 0;
    boolean s2 = sign(x1, y1, x3, y3, x, y) > 0;
    boolean s3 = sign(x2, y2, x3, y3, x, y) > 0;
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    if ((s1 && s2 && s3) || (!s1 && !s2 && !s3)) {
      out.println("YES");
    } else {
      out.println("NO");
    }

    out.flush();
    out.close();
  }

  static double sign(double x1, double y1, double x2, double y2, double x, double y) {
    return (x2 - x1) * (y - y2) - (x - x2) * (y2 - y1);
  }

}
