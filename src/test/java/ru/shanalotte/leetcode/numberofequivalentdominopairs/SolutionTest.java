package ru.shanalotte.leetcode.numberofequivalentdominopairs;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  public void shouldWork() {

  }

  @Test
  public void pairsNumberOfOneIsZero() {
    assertThat(new Solution().numberOfPairsBetweenNNumbers(1)).isZero();
  }

  @Test
  public void pairsNumberBetweenTwoIsOne() {
    assertThat(new Solution().numberOfPairsBetweenNNumbers(2)).isOne();
  }

  @Test
  public void example1() {
    assertThat(new Solution().numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}})).isEqualTo(3);
  }

  @Test
  public void example2() {
    assertThat(new Solution().numEquivDominoPairs(new int[][]{{1,2},{2,1},{3,4},{5,6}})).isEqualTo(1);
  }


}