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

  public ListNode insertIntoSorted(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
      return newNode;
    }
    ListNode current = head;
    ListNode temp = null;
    // IF we haven't reached the end of list,
    // AND the data is less than the current node's data,
    // THEN keep traversing the sorted linked list
    while (current != null && current.data < newNode.data) {
      // Assign the current node to the temp variable
      temp = current;
      // and move current to the next node
      current = current.next;
    }
    // ONCE we've EITHER reached the end of the list
    // OR the current node's data is greater than the newNode's data
    // Assign the newNode's next property to be the current node (which has a
    // greater data property)
    newNode.next = current;
    // and assign the temp.next's value to the newNode (placing it in the linked
    // list)
    temp.next = newNode;
    // return the linked list
    return head;
  }

  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();

    ListNode head = new ListNode(1);
    ListNode second = new ListNode(8);
    ListNode third = new ListNode(10);
    ListNode fourth = new ListNode(16);

    head.next = second;
    second.next = third;
    third.next = fourth;
    sll.display(head); // 1 --> 8 --> 10 --> 16 --> null

    sll.insertIntoSorted(head, 13);
    sll.display(head); // 1 --> 8 --> 10 --> 13 --> 16 --> null
  }
}
