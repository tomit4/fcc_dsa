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

  // NOTE: This can be thought of as a sort of "zigzagging" between the two
  // compared lists, comparing their data values, and depending on them,
  // determines how they are merged into a new ListNode
  public ListNode merge(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0);
    // Our new ListNode
    ListNode tail = dummy;
    // As long as both lists still have elements in them, traverse both...
    while (a != null && b != null) {
      // if the first list node, a, has data that is less than the second list,
      // b, node's data
      if (a.data < b.data) {
        // assign the next property of tail.next to a
        // NOTE: The reason dummy cannot just be null is because we need the
        // ListNode's next property to reference
        tail.next = a;
        // and reassign a to the next node on the list
        a = a.next;
      } else {
        // otherwize, do the same, but for b
        tail.next = b;
        b = b.next;
      }
      // either way, traverse the list by assigning tail to it's next node
      tail = tail.next;
    }
    // if a ended the list first, then the tail.next property is set to the last
    // node of b, otherwise it is assigned the last node of a
    tail.next = a == null ? b : a;
    // ignore the data value of dummy (0), and just return the rest of the list
    // by returning its next property (the linked list)
    return dummy.next;
  }

  // NOTE: An alternative approach that doesn't create a dummy ListNode instance
  // INSTEAD, prior to traversing the list, we establish the head at a or b
  // depending on which data property is greater, thusly creating a new node
  // Once that is established, we can then move the tail around by referencing
  // the new value of head
  public ListNode mergeTwo(ListNode a, ListNode b) {
    ListNode head = null;
    if (a.data <= b.data) {
      head = a;
      a = a.next;
    } else {
      head = b;
      b = b.next;
    }
    ListNode tail = head;
    while (a != null && b != null) {
      if (a.data < b.data) {
        tail.next = a;
        a = a.next;
      } else {
        tail.next = b;
        b = b.next;
      }
      tail = tail.next;
    }
    tail.next = a == null ? b : a;
    return head;
  }

  public static void main(String[] args) {
    SinglyLinkedList a = new SinglyLinkedList();
    a.insertLast(1);
    a.insertLast(4);
    a.insertLast(8);

    SinglyLinkedList b = new SinglyLinkedList();
    b.insertLast(3);
    b.insertLast(6);

    SinglyLinkedList sll = new SinglyLinkedList();

    ListNode mergedListOne = sll.merge(a.head, b.head);
    sll.display(mergedListOne); // 1 --> 3 --> 4 --> 6 --> 8 --> null

    ListNode mergedListTwo = sll.mergeTwo(a.head, b.head);
    sll.display(mergedListTwo); // 1 --> 3 --> 4 --> 6 --> 8 --> null
  }
}
