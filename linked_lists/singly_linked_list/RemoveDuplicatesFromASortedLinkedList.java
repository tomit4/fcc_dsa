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

  public void display(ListNode head) {
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

  public ListNode deleteFirst() {
    // List is empty
    if (head == null) {
      return null;
    }
    ListNode temp = head;
    head = head.next;
    temp.next = null;
    return temp;
  }

  public ListNode deleteLast() {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode current = head;
    ListNode previous = null;
    while (current.next != null) {
      previous = current;
      current = current.next;
    }
    previous.next = null;
    return current;
  }

  public void delete(int position) {
    // IF we start at the beginning, we simply assign
    // the next ListNode to the head variable
    if (position == 1) {
      head = head.next;
    } else {
      ListNode previous = head;
      int count = 1;
      while (count < position - 1) {
        previous = previous.next;
        count++;
      }
      // NOTE: By storing the previous.next in a new ListNode, current,
      // AND assigning the previous.next to the current.next,
      // we are essentially SKIPPING over the original node at this position,
      // Then relying on the garbage collector to delete the node,
      // as there is no longer a reference to it.
      ListNode current = previous.next;
      previous.next = current.next;
    }
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

  public void insert(int data, int position) {
    ListNode node = new ListNode(data);
    if (position == 1) {
      node.next = head;
      head = node;
    } else {
      ListNode previous = head;
      int count = 1;
      while (count < position - 1) {
        previous = previous.next;
        count++;
      }
      ListNode current = previous.next;
      node.next = current;
      previous.next = node;
    }
  }

  public boolean find(ListNode head, int searchKey) {
    if (head == null) {
      return false;
    }
    ListNode current = head;
    while (current != null) {
      if (current.data == searchKey) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  public void removeDuplicates(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode current = head;
    // As long as the node isn't empty (i.e. we haven't reached the end...)
    while (current != null && current.next != null) {
      // if the current data value is equal to the next data value, then...
      if (current.data == current.next.data) {
        // point the current node's next property to the next node's next
        // property (skipping it)
        // and let the garbage collector handle deleting the skipped over node
        current.next = current.next.next;
      } else {
        // simply move onto the next node
        current = current.next;
      }
    }
  }

  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();

    ListNode head = new ListNode(1);
    ListNode second = new ListNode(1);
    ListNode third = new ListNode(2);
    ListNode fourth = new ListNode(3);
    ListNode fifth = new ListNode(3);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;

    sll.display(head); // 1 --> 1 --> 2 --> 3 --> 3 --> null
    sll.removeDuplicates(head);
    sll.display(head); // 1 --> 2 --> 3 --> null
  }
}
