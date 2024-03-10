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
    last.next = temp;
    length++;
  }

  public static void main(String[] args) {
    CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

    csll.createCircularLinkedList();
    csll.display(); // 1 --> 5 --> 10 --> 15
    csll.insertFirst(20);
    csll.display(); // 20 --> 1 --> 5 --> 10 --> 15
  }
}
