package ru.shanalotte.hashmap.numberofequivalentdominopairs;

import java.util.HashMap;
import java.util.Map;

//TODO get rid of overhead object creations
class Solution {

  public int numEquivDominoPairs(int[][] dominoes) {
    Map<DominoPair, Integer> dominoPairMap = new HashMap<>();
    for (int[] dominoArray : dominoes) {
      dominoPairMap.merge(DominoPair.from(dominoArray), 1, Integer::sum);
    }
    int duplicatedPairsQty = dominoPairMap.values()
        .stream()
        .reduce(0, (acc, qtyOfASingleDominoPair) -> acc + numberOfPairsBetweenNNumbers(qtyOfASingleDominoPair));
    return duplicatedPairsQty;
  }

  public int numberOfPairsBetweenNNumbers(int n) {
    return n * (n - 1) / 2;
  }

  private static class DominoPair {

    private final int firstNumber;
    private final int secondNumber;
    public DominoPair(int firstNumber, int secondNumber) {
      this.firstNumber = firstNumber;
      this.secondNumber = secondNumber;
    }

    public static DominoPair from(int[] array) {
      return new DominoPair(array[0], array[1]);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      DominoPair that = (DominoPair) o;
      return (firstNumber == that.firstNumber && secondNumber == that.secondNumber
          || firstNumber == that.secondNumber && secondNumber == that.firstNumber);
    }

    @Override
    public int hashCode() {
      return firstNumber <= secondNumber ? firstNumber * 10 + secondNumber : secondNumber * 10 + firstNumber;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("DominoPair{");
      sb.append("firstNumber=").append(firstNumber);
      sb.append(", secondNumber=").append(secondNumber);
      sb.append('}');
      return sb.toString();
    }
  }
}