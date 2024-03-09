## Doubly Linked List

- It is also called as a two way linked list.
- Give a node, we can navigate list in both forward and backward direction,
  which is not possible in a Singly Linked List.
- A node in a Singly Linked List can only be deleted if we have a pointer to its
  previous node. But in Doubly Linked List we can delete the node even if we don't
  have a pointer to its previous node.
- Basics of Doubly Linked List:

```
<---previous|data|next--->
---------LISTNODE---------
```

Basic Structure Of Doubly Linked List And ListNode In Java:

```java
public class ListNode {
    int data;
    ListNode previous;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}
```

An Example Of A Basic Doubly Linked List With Data:

```
----------head---------------------------------------tail----------
null <-- [ , 1, ] <==> [ , 10, ] <==> [ , 15, ] <==> [ , 65, ] --> null
```
