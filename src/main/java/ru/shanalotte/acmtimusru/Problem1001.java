package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem1001
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    List<Double> numbers = new ArrayList<>();
    while (in.hasNextDouble()) {
      numbers.add(in.nextDouble());
    }
    Collections.reverse(numbers);
    for (Double number : numbers) {
      out.println(Math.sqrt(number));
    }
    out.flush();
  }
}