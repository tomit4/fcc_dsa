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

  public static void main(String[] args) {
    CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

    csll.createCircularLinkedList();
  }
}
