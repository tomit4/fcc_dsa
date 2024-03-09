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

  public void deleteNode(ListNode head, int key) {
    ListNode current = head;
    ListNode temp = null;
    // IF we find the key on the first value (i.e. in the head node)
    // THEN we simply assign the head to the next node and
    // let garbage collection do the rest
    if (current != null && current.data == key) {
      head = current.next;
      return;
    }
    // Otherwise we traverse the linked list until we find the key,
    // moving our temp and current variables along the linked list
    while (current != null && current.data != key) {
      temp = current;
      current = current.next;
    }
    // if current still ends up being null (end of list),
    // and the key was never found, simply return
    if (current == null)
      return;
    // otherwise we just SKIP over to the next value,
    // assigning the temp.next property to the
    // current(deleted value's) next property
    // and garbage collection removes the data with the key value (current)
    temp.next = current.next;
  }

  public boolean containsLoop(ListNode head) {
    // Create two pointers both which point to the head of the list
    ListNode fastPtr = head;
    ListNode slowPtr = head;
    // while fastPtr and fastPtr.next don't reach the end of the list( there
    // isn't any, this would be infinite were it not for the condition)
    while (fastPtr != null && fastPtr.next != null) {
      // Reassign fastPtr to two node's ahead of its current position
      fastPtr = fastPtr.next.next;
      // and assign slowPtr to simply the next node
      slowPtr = slowPtr.next;
      // IF at any point the slowPtr is equal to the fastPtr, then a loop is
      // detected and we break out returning true
      if (slowPtr == fastPtr)
        return true;
    }
    // otherwise return false
    return false;
  }

  // helper function to findStartOfLoop()
  private ListNode getStartingNode(ListNode head, ListNode slowPtr) {
    // we assign a new temp pointer to the head of the list
    ListNode temp = head;
    // Loops over the list, moving each temp and slowPtr's along until they
    // are equal

    // NOTE: Because slowPtr is already "stuck" in the loop, it will continue to
    // loop through the loop
    //, MEANWHILE the temp pointer willl continue along the linear list, until
    // it reaches the node where
    // the loop begins, and slowPtr will meet, giving us the starting node  of
    // the loop as temp
    // see ~8:10 of video for explanation
    while (slowPtr != temp) {
      temp = temp.next;
      slowPtr = slowPtr.next;
    }

    // when they are equal, we have found the starting node of our loop
    return temp;
  }

  public ListNode findStartOfLoop(ListNode head) {
    ListNode fastPtr = head;
    ListNode slowPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (slowPtr == fastPtr) {
        return getStartingNode(head, slowPtr);
      }
    }
    return slowPtr;
  }

  // Helper function to detectAndRemoveLoop()
  // Very similar to getStartingNode(),
  // Instead of returning the starting node, it simply removes the next
  // reference, allowing garbage collection to remove the node where the loop
  // starts (i.e. the node where the first instance of next reference)
  private void removeLoop(ListNode head, ListNode slowPtr) {
    ListNode temp = head;
    // NOTE that unlike getStartingNode(), we don't need to check if slowPtr
    // is equal to temp, instead we check if slowPtr.next == temp.next,
    // this is because ultimately we want to remove the "next" of the last node
    // of the loop, and NOT the node where the loop begins
    while (slowPtr.next != temp.next) {
      temp = temp.next;
      slowPtr = slowPtr.next;
    }
    slowPtr.next = null;
  }

  public void detectAndRemoveLoop(ListNode head) {
    if (head == null)
      return;
    ListNode fastPtr = head;
    ListNode slowPtr = head;
    while (fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (slowPtr == fastPtr) {
        removeLoop(head, slowPtr);
        return;
      }
    }
  }

  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();

    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fourth = new ListNode(4);
    ListNode fifth = new ListNode(5);
    ListNode sixth = new ListNode(6);

    head.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;
    fifth.next = sixth;

    // NOTE: Two nodes point to third, a "loop"
    sixth.next = third;
    // sll.display(head); // infinite loop
    sll.detectAndRemoveLoop(head);
    sll.display(head); // 1 --> 2 --> 3 --> 4 --> 5 --> 6 --> null
  }
}
