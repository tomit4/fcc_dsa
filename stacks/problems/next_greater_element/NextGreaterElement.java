import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
  // NOTE: top refers to index of array
  private int top;
  private int[] arr;

  // Constructors
  public void push(int data) {
    if (isFull()) {
      throw new RuntimeException("Stack Is Full !!!");
    }
    top++;
    arr[top] = data;
  }

  public int pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack Is Empty !!!");
    }
    int result = arr[top];
    top--;
    return result;
  }

  public int peek() {
    if (isEmpty()) {
      throw new RuntimeException("Stack Is Empty !!!");
    }
    return arr[top];
  }

  public boolean isFull() { return arr.length == size(); }
  public boolean isEmpty() { return top < 0; }
  public int size() { return top + 1; }

  public Stack(int capacity) {
    top = -1;
    arr = new int[capacity];
  }

  public Stack() { this(10); }

  public int[] nextGreaterElement(int[] arr) {
    int[] result = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      if (!stack.isEmpty()) {
        while (!stack.isEmpty && stack.peek() <= arr[i]) {
          stack.pop();
        }
      }
      if (stack.isEmpty()) {
        result[i] = -1;
      } else {
        result[i] = stack.peek();
      }
      stack.push(arr[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(4);
    stack.push(7);
    stack.push(3);
    stack.push(4);
    stack.push(8);
    stack.push(1);
    System.out.println(Arrays.toString(stack));
  }
}
