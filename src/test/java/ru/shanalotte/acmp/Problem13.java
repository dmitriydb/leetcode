package ru.shanalotte.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class Problem13 {

  private static class GameResult {
    int cows;
    int bulls;
  }

  private static GameResult determineGameResult(int target, int guess) {
    int aBitsHolder = 0;
    GameResult gameResult = new GameResult();
    int temp = target;
    for (int i = 0; i < 4; i++) {
      int a = temp % 10;
      aBitsHolder = aBitsHolder | (1 << a);
      temp = temp / 10;
    }
    for (int i = 0; i < 4; i++) {
      int a = target % 10;
      int b = guess % 10;
      if (a == b) {
        gameResult.bulls++;
      } else
      if ((aBitsHolder >> b) % 2 == 1) {
        gameResult.cows++;
      }
      target = target / 10;
      guess = guess / 10;
    }
    return gameResult;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out, true);
    int a = in.nextInt();
    int b = in.nextInt();
    GameResult gameResult = determineGameResult(a, b);
    out.printf("%d %d%n", gameResult.bulls, gameResult.cows);
    in.close();
    out.close();
  }

}
