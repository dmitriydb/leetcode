package ru.shanalotte.acmtimusru.template;

import java.io.*;
import java.util.*;

public class SolutionTemplate
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int a = in.nextInt();
    int b = in.nextInt();
    out.println(a + b);

    out.flush();
  }
}