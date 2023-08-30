package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem340 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    Box firstBox = new Box(in.nextInt(), in.nextInt(), in.nextInt());
    in.nextLine();
    Box secondBox = new Box(in.nextInt(), in.nextInt(), in.nextInt());
    if (firstBox.equals(secondBox)) {
      out.println("Boxes are equal");
    } else if (firstBox.canFit(secondBox)) {
      out.println("The first box is larger than the second one");
    } else if (secondBox.canFit(firstBox)) {
      out.println("The first box is smaller than the second one");
    } else {
      out.println("Boxes are incomparable");
    }
    in.close();
    out.close();
  }

  static class Box {
    private final int sideA;
    private final int sideB;
    private final int sideC;

    public Box(int sideA, int sideB, int sideC) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(List.of(sideA, sideB, sideC));
      this.sideA = priorityQueue.remove();
      this.sideB = priorityQueue.remove();
      this.sideC = priorityQueue.remove();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Box box = (Box) o;
      return sideA == box.sideA && sideB == box.sideB && sideC == box.sideC;
    }

    public boolean canFit(Box secondBox) {
      return this.sideC >= secondBox.sideC && this.sideB >= secondBox.sideB && this.sideA >= secondBox.sideA;
    }
  }

}
