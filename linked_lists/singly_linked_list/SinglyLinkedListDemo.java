public class SinglyLinkedListDemo {
  // just demo, does not run
  public void createSinglyLinnkedList() {
    // head is instance variable,
    // initial value is set to 10, but head.next points to null
    head = new ListNode(10);

    ListNode second = new ListNode(1);  // init val 1, next is null
    ListNode third = new ListNode(8);   // init val 8, next is null
    ListNode fourth = new ListNode(11); // init val 11, next is null

    head.next = second;  // head value is 10, next is second.val, which is 1
    second.next = third; // second value is 1, next is third.val, which is 8
    third.next = fourth; // third value is 8, next is fourth.val, which is 11
                         // fourth.next still is null
  }
  public static void main(String[] args) {
    System.out.println("Just a Demo, does not run anything");
  }
}
