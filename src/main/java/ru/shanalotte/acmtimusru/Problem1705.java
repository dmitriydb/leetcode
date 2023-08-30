package ru.shanalotte.acmtimusru;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1705 {

  private static class NamedRanges {

    private Map<Integer, String> rangesMap = new HashMap<>();

    public NamedRanges(NamedRange... ranges) {
      for (NamedRange range : ranges) {
        this.addRange(range);
      }
    }

    private void addRange(NamedRange range) {
      for (int i = range.lowerBound; i<=range.upperBound;i++) {
        rangesMap.put(i, range.name);
      }
    }

    public String at(int number) {
      return rangesMap.get(number);
    }
  }

  private static class NamedRange {
    private final int lowerBound;
    private final int upperBound;
    private final String name;

    public NamedRange(int lowerBound, int upperBound, String name) {
      this.lowerBound = lowerBound;
      this.upperBound = upperBound;
      this.name = name;
    }

    public boolean includes(int number) {
       return number >= lowerBound && number <= upperBound;
    }

    public boolean lessThan(int number) {
      return number > this.upperBound;
    }

    public boolean moreThan(int number) {
      return number < this.lowerBound;
    }

    public String name() {
      return name;
    }
  }

  public static void main(String[] args)
  {
     NamedRanges namedRanges = new NamedRanges(new NamedRange(1, 4, "few"),
         new NamedRange(5, 9, "several"),
         new NamedRange(10, 19, "pack"),
         new NamedRange(20, 49, "lots"),
         new NamedRange(50, 99, "horde"),
         new NamedRange(100, 249, "throng"),
         new NamedRange(250, 499, "swarm"),
         new NamedRange(500, 999, "zounds"),
         new NamedRange(1000, 2000, "legion"));

    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = in.nextInt();


    out.println(namedRanges.at(n));
    out.flush();
    in.close();
    out.close();
  }
}
