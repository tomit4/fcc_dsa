public class MaxPriorityQueue {
  Integer[] heap;
  int n;

  public MaxPriorityQueue(int capacity) {
    // recall that a Max Priority Queue starts at index 1, index 0 is not used
    // and is null
    heap = new Integer[capacity + 1];
    n = 0;
  }

  public boolean isEmpty() { return n == 0; }

  public int size() { return n; }

  public static void main(String[] args) {
    MaxPriorityQueue maxpq = new MaxPriorityQueue(3);
    System.out.println(maxpq.size());    // 0
    System.out.println(maxpq.isEmpty()); // true
  }
}
