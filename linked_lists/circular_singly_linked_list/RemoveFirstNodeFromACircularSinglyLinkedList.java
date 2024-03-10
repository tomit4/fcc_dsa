import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

  private ListNode last;
  private int length;

  private class ListNode {
    private ListNode next;
    private int data;

    public ListNode(int data) { this.data = data; }
  }

  public CircularSinglyLinkedList() {
    last = null;
    length = 0;
  }

  public boolean isEmpty() { return length == 0; }

  public int length() { return length; }

  public void createCircularLinkedList() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(5);
    ListNode third = new ListNode(10);
    ListNode fourth = new ListNode(15);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = first;
    last = fourth;
    length = 4;
  }

  public void display() {
    if (last == null) {
      return;
    }
    ListNode first = last.next;
    while (first != last) {
      System.out.print(first.data + " --> ");
      first = first.next;
    }
    System.out.println(first.data);
  }

  public void insertFirst(int data) {
    ListNode temp = new ListNode(data);
    if (last == null) {
      last = temp;
    } else {
      // essentially temp.next becomes last.next (the first node, temp is placed
      // before first node)
      temp.next = last.next;
    }
    // last.next now points to temp, which is the new first node
    // NOTE: if temp is also last, this fulfills the circular requirement as it
    // points to itself
    last.next = temp;
    length++;
  }

  public void insertLast(int data) {
    ListNode temp = new ListNode(data);
    if (last == null) {
      last = temp;
      // explicitly set the linked list to be circular, point it to itself
      last.next = last;
    } else {
      // set temp's next pointer to the first element in the list
      temp.next = last.next;
      // reset last's next pointer to point to the new temp node
      last.next = temp;
      // finally make the last variable reference the new temp node
      // making it the last node in the list
      last = temp;
    }
    length++;
  }

  public ListNode removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    // only one element, removing only element...
    ListNode temp = last.next;
    if (last.next == last) {
      last = null;
    } else {
      last.next = temp.next;
    }
    temp.next = null;
    length--;
    return temp;
  }

  public static void main(String[] args) {
    CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

    csll.createCircularLinkedList();
    csll.display(); // 1 --> 5 --> 10 --> 15

    csll.insertFirst(20);
    csll.display(); // 20 --> 1 --> 5 --> 10 --> 15

    csll.insertLast(42);
    csll.display(); // 20 --> 1 --> 5 --> 10 --> 15 --> 42

    csll.removeFirst();
    csll.display(); // 1 --> 5 --> 10 --> 15 --> 42
  }
}
