package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem2066
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(a);
    pq.add(b);
    pq.add(c);
    int l1 = pq.remove();
    int l2 = pq.remove();
    int l3 = pq.remove();
    int f1 = l1 - l2 * l3;
    int f2 = l1 - l2 - l3;
    out.println(Math.min(f1, f2));


  }

}