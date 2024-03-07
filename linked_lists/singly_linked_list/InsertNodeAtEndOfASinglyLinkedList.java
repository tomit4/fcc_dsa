public class SinglyLinkedList {
  private ListNode head;

  private static class ListNode {
    private int data; // Generic Type
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public void display() {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public int getLength() {
    int count = 0;
    ListNode current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public void insertFirst(int value) {
    ListNode newNode = new ListNode(value);
    newNode.next = head;
    head = newNode;
  }

  public void insertLast(int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      head = newNode;
      return;
    }
    ListNode current = head;
    while (null != current.next) {
      current = current.next;
    }
    current.next = newNode;
  }

  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();
    sll.head = new ListNode(10);
    ListNode second = new ListNode(1);
    ListNode third = new ListNode(8);
    ListNode fourth = new ListNode(11);

    // Now we will connect them together to form a chain
    sll.head.next = second; // 10 --> 1
    second.next = third;    // 10 --> 1 --> 8
    third.next = fourth;    // 10 --> 1 --> 8 --> 11 --> null
    // sll.insertFirst(11);
    // sll.insertFirst(8);
    // sll.insertFirst(1);
    //
    sll.insertLast(11);
    sll.insertLast(8);
    sll.insertLast(1);

    sll.display(); // 10 --> 1 --> 8 --> 11 --> 11 --> 8 --> 1 --> null
    // int length = sll.getLength(); // 4
    // System.out.println(length);
  }
}
