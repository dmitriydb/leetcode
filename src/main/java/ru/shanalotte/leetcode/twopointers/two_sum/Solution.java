package ru.shanalotte.leetcode.twopointers.two_sum;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.prefs.BackingStoreException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {


  static class MyCollector implements Collector<Integer, int[], Integer> {

    @Override
    public Supplier<int[]> supplier() {
      return () -> new int[1];
    }

    @Override
    public BiConsumer<int[], Integer> accumulator() {
      return (arr, val) -> {arr[0] += val; };
    }

    @Override
    public BinaryOperator<int[]> combiner() {
      return (arr1, arr2) -> {return new int[]{arr1[0] + arr2[0]};};
    }

    @Override
    public Function<int[], Integer> finisher() {
      return (arr) -> arr[0];
    }

    @Override
    public Set<Characteristics> characteristics() {
      return Set.of();
    }
  }

  public static void main(String[] args) throws BackingStoreException, IOException {
    List<Locale> locales = List.of(Locale.getAvailableLocales());
    var collect = locales.stream().collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
    System.out.println(collect);
  }

}