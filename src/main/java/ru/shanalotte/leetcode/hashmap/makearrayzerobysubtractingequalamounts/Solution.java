package ru.shanalotte.leetcode.hashmap.makearrayzerobysubtractingequalamounts;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
  public int minimumOperations(int[] nums) {
    return (int) Arrays.stream(nums)
        .boxed()
        .filter(num -> num != 0)
        .collect(Collectors.toSet())
        .size();
  }
}
