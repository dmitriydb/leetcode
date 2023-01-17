package ru.shanalotte.acmp.menshikov.training2;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {

  private static PrintWriter out;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    out = new PrintWriter(System.out);
    String line = in.nextLine();
    char[] symbols = line.toCharArray();
    boolean[] isSymbolUsed = new boolean[symbols.length];
    List<Integer> positions = new ArrayList<>();
    generatePermutation(symbols, isSymbolUsed, positions);
    in.close();
    out.close();
  }

  private static void generatePermutation(char[] symbols, boolean[] isSymbolUsed, List<Integer> positions) {
    if (positions.size() == symbols.length) {
      printPermutation(symbols, positions);
      return;
    }
    for (int i = 0; i < symbols.length; i++) {
      if (!isSymbolUsed[i]) {
        isSymbolUsed[i] = true;
        positions.add(i);

        generatePermutation(symbols, isSymbolUsed, positions);

        isSymbolUsed[i] = false;
        positions.remove(positions.size() - 1);
      }
    }
  }

  private static void printPermutation(char[] symbols, List<Integer> positions) {
    for (Integer position : positions) {
      out.print(symbols[position]);
    }
    out.println();
  }

}
