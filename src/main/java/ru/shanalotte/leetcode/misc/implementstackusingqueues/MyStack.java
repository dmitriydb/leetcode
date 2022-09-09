package ru.shanalotte.leetcode.misc.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

  private Queue<Integer> queue1 = new LinkedList<>();

  public MyStack() {

  }

  public void push(int x) {
    int n = queue1.size();
    queue1.offer(x);
    for (int i = 0; i < n; i++) {
      int t = queue1.poll();
      queue1.offer(t);
    }
  }

  public int pop() {
    return queue1.poll();
  }

  public int top() {
    return queue1.peek();
  }

  public boolean empty() {
    return queue1.isEmpty();
  }

  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
  }
}