package ru.shanalotte.leetcode;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import ru.shanalotte.leetcode.prefixsum.rangesumqueryimmutable.NumArray;

public class NumArrayTest {

  @Test
  public void paperCase1() {
    int[] testCase = {1, 2, 3, 4, 5};
    assertThat(new NumArray(testCase).sumRange(2, 4)).isEqualTo(12);
  }

}