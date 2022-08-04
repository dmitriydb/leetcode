package ru.shanalotte.leetcode.strings.thousandseparator.v1;

class Solution {
  public String thousandSeparator(int n) {
    StringBuilder formattedString = new StringBuilder();
    int processedCharactersQty = 0;
    do {
      int nextDigit = n % 10;
      processedCharactersQty++;
      formattedString.insert(0, nextDigit);
      if (processedCharactersQty % 3 == 0) {
        formattedString.insert(0, ".");
      }
      n = n / 10;
    } while (n != 0);
    cropLeadingDotIfPresent(formattedString);
    return formattedString.toString();
  }

  private void cropLeadingDotIfPresent(StringBuilder formattedString) {
    if (formattedString.charAt(0) == '.') {
      formattedString.delete(0, 1);
    }
  }
}