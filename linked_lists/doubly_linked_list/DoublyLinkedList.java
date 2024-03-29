public class DoublyLinkedList {
  private ListNode head;
  private ListNode tail;
  private int length;

  private static class ListNode {
    private int data;
    private ListNode previous;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
      this.previous = null;
    }
  }

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public boolean isEmpty() {
    return length == 0; // head == null
  }

  public int length() { return length; }

  public void insertLast(int value) {
    ListNode newNode = new ListNode(value);
    if (isEmpty()) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    newNode.previous = tail;
    tail = newNode;
    length++;
  }

  public void displayForward() {
    if (head == null)
      return;

    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " --> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public void displayBackward() {
    if (tail == null)
      return;

    ListNode temp = tail;
    while (temp != null) {
      System.out.print(temp.data + " --> ");
      temp = temp.previous;
    }
    System.out.println("null");
  }

  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.insertLast(1);
    dll.insertLast(10);
    dll.insertLast(15);
    dll.insertLast(25);

    dll.displayForward();  // 1 --> 10 --> 15 --> 25 --> null
    dll.displayBackward(); // 25 --> 15 --> 10 --> 1 --> null
  }
}
