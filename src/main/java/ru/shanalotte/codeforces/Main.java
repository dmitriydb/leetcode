package ru.shanalotte.codeforces;

public class Main {

  public String finalString(String s) {
    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == 'i') {
        result.reverse();
      } else {
        result.append(c);
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Main().finalString("string"));
  }

}
