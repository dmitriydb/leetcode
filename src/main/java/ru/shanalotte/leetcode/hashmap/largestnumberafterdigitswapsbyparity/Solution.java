package ru.shanalotte.leetcode.hashmap.largestnumberafterdigitswapsbyparity;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int largestInteger(int num) {
    Map<Integer, Integer> digitsFrequenciesMap = new HashMap<>();
    countFrequencies(num, digitsFrequenciesMap);
    int resultNumber = 0;
    int powerOfTen = 1;
    int nextSmallestEvenNumber = 0;
    int nextSmallestOddNumber = 1;
    do {
      int nextDigit = num % 10;
      if (nextDigit % 2 == 0) {
        nextSmallestEvenNumber = grabNextDigitFromMap(digitsFrequenciesMap, nextSmallestEvenNumber);
        nextDigit = nextSmallestEvenNumber;
      } else {
        nextSmallestOddNumber = grabNextDigitFromMap(digitsFrequenciesMap, nextSmallestOddNumber);
        nextDigit = nextSmallestOddNumber;
      }
      resultNumber = powerOfTen * nextDigit + resultNumber;
      powerOfTen *= 10;
      num = num / 10;
    } while (num != 0);
    return  resultNumber;
  }

  private int grabNextDigitFromMap(Map<Integer, Integer> digitsFrequenciesMap, int index) {
    while (!digitsFrequenciesMap.containsKey(index) || digitsFrequenciesMap.get(index) == 0) {
      index += 2;
    }
    digitsFrequenciesMap.merge(index, -1, Integer::sum);
    return index;
  }

  private void countFrequencies(int number, Map<Integer, Integer> digitsFrequenciesMap) {
    do {
      int nextDigit = number % 10;
      digitsFrequenciesMap.merge(nextDigit, 1, Integer::sum);
      number = number / 10;
    } while (number != 0);
  }

  public static void main(String[] args) {
    System.out.println( new Solution().largestInteger(1234));
  }
}
