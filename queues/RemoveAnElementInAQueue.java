import java.util.NoSuchElementException;

public class Queue {

  private ListNode front;
  private ListNode rear;
  private int length;

  public Queue() {
    this.front = null;
    this.rear = null;
    this.length = 0;
  }

  private class ListNode {
    int data;
    ListNode next;
    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public int length() { return length; }

  public boolean isEmpty() { return length == 0; }

  public void print() {
    if (isEmpty()) {
      return;
    }

    ListNode current = front;
    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public void enqueue(int data) {
    ListNode temp = new ListNode(data);
    if (isEmpty()) {
      front = temp;
    } else {
      rear.next = temp;
    }
    rear = temp;
    length++;
  }

  public int first() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return front.data;
  }

  public int last() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return rear.data;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    int result = front.data;
    // Front is reassigned to the next element in line
    front = front.next;
    // If there are no more remaining elements in the queue, then clear it
    if (front == null) {
      rear = null;
    }
    length--;
    // NOTE: that if you set this to void and omit this return, it still works,
    // as the front, rear, and length variables are within the scope of this
    // class
    return result;
  }

  public static void main(String[] args) {
    Queue queue = new Queue();
    queue.enqueue(10);
    queue.enqueue(15);
    queue.enqueue(20);
    queue.print(); // 10 --> 15 --> 20 --> null
    queue.dequeue();
    queue.print(); // 15 --> 20 --> null
  }
}
