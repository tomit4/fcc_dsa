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

  public void insert(int x) {
    if (n == heap.length - 1) {
      resize(2 * heap.length);
    }
    n++;
    heap[n] = x;
    swim(n);
  }

  // k is n, it is simply referred to as k in swim() so as to not overwrite it
  // when called
  private void swim(int k) {
    while (k > 1 && heap[k / 2] < heap[k]) {
      int temp = heap[k];
      heap[k] = heap[k / 2];
      heap[k / 2] = temp;
      // returns the index of the traversal to the parent node
      // (until above at k > 1, i.e. we reach the root node)
      k = k / 2;
    }
  }

  private void resize(int capacity) {
    Integer[] temp = new Integer[capacity];
    for (int i = 0; i < heap.length; i++) {
      temp[i] = heap[i];
    }
    heap = temp;
  }
  public void printMaxHeap() {
    for (int i = 1; i <= n; i++) {
      System.out.print(heap[i] + " ");
    }
  }

  public static void main(String[] args) {
    MaxPriorityQueue maxpq = new MaxPriorityQueue(3);
    maxpq.insert(4);
    maxpq.insert(5);
    maxpq.insert(2);
    maxpq.insert(6);
    maxpq.insert(1);
    maxpq.insert(3);

    maxpq.printMaxHeap(); // 6 5 3 4 1 2
    System.out.println("");
  }
}

/*
 *              (6)
 *              / \
 *             5   3
 *            / \
 *           4   1
 *          /
 *         2
 * */
