package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem633 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    out.println(in.nextLine() + ": " +
                Stream.of(in.nextLine(), in.nextLine(), in.nextLine()).sorted().collect(Collectors.joining(", ")));
    in.close();
    out.close();
  }

}
