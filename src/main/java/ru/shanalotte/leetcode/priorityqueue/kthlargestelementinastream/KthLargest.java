package ru.shanalotte.leetcode.priorityqueue.kthlargestelementinastream;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> greaterNumbers = new PriorityQueue<>();
    private int kthLargest = -1;
    public KthLargest(int k, int[] nums) {
      determineKthLargest(k, nums);
    }

    private void determineKthLargest(int k, int[] nums) {
      Arrays.sort(nums);
      int q = nums.length - k;
      if (q < 0) {
        q = -1;
      } else {
        kthLargest = nums[q];
      }
      for (int i = q + 1; i < nums.length; i++) {
        greaterNumbers.offer(nums[i]);
      }
    }

    public int add(int val) {
      if (kthLargest == -1 || val > kthLargest) {
        greaterNumbers.offer(val);
        kthLargest = greaterNumbers.poll();
      }
      return kthLargest;
    }

}


