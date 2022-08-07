package ru.shanalotte.leetcode.bitoperations.convertanumbertohexadecimal;

public class Solution {

  public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
  public String toHex(int num) {
    if (num == Integer.MIN_VALUE) {
      return "80000000";
    }
    boolean isNegative = num < 0;
    num = Math.abs(num);
    StringBuilder number = new StringBuilder(16);
    convertToHex(num, number);
    if (isNegative) {
      flipBits(number);
      appendLeadingFlippedZeros(number);
      addOne(number);
    }
    return number.toString();
  }

  private void addOne(StringBuilder number) {
    int remainder = 1;
    int i = number.length() - 1;
    do {
      int newValue = remainder + hexToDecimal(number.charAt(i)) + 1;
      if (newValue > 16) {
        newValue = 1;
      }
      else {
        remainder = 0;
      }
      number.setCharAt(i, DIGITS[newValue - 1]);
      i--;
    } while (remainder > 0);
  }

  private void appendLeadingFlippedZeros(StringBuilder number) {
    while (number.length() < 8) {
      number.insert(0, 'f');
    }
  }

  private void convertToHex(int num, StringBuilder number) {
    do {
      number.insert(0, DIGITS[num % 16]);
      num /= 16;
    } while (num != 0);
  }

  private void flipBits(StringBuilder number) {
    for (int i = 0; i < number.length(); i++) {
      number.setCharAt(i, flipHex(number.charAt(i)));
    }
  }

  private char flipHex(char hexDigit) {
    int intValue = hexToDecimal(hexDigit);
    return DIGITS[15 - intValue];
  }

  private int hexToDecimal(char hexDigit) {
    int intValue = 0;
    if (hexDigit >= 'a' && hexDigit <= 'f') {
      intValue = 10 + hexDigit - 'a';
    } else {
      intValue = hexDigit - '0';
    }
    return intValue;
  }


  public static void main(String[] args) {
    System.out.println(new Solution().toHex(-100000));
  }
}
