package ru.shanalotte.leetcode.stack;

import java.util.Stack;

class MyQueue {

  private Stack<Integer> popStack = new Stack<>();
  private Stack<Integer> pushStack = new Stack<>();

  public MyQueue() {

  }

  public void push(int x) {
    pushStack.push(x);
  }

  public int pop() {
    if (popStack.isEmpty()) {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
    }
    return popStack.pop();
  }

  public int peek() {
    if (popStack.isEmpty()) {
      while (!pushStack.isEmpty()) {
        popStack.push(pushStack.pop());
      }
    }
    return popStack.peek();
  }

  public boolean empty() {
    return popStack.isEmpty() && pushStack.isEmpty();
  }
}