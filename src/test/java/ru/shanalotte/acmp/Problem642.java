package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem642 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    int n = in.nextInt();
    int s = in.nextInt();
    int count = 0;
    in.nextLine();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      priorityQueue.add(in.nextInt());
    }
    while (!priorityQueue.isEmpty()) {
      int price = priorityQueue.remove();
      if (s - price < 0) {
        break;
      }
      s -= price;
      count++;
    }
    out.println(count);
    in.close();
    out.close();
  }

}
