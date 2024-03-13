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

  public int deleteMax() {
    int max = heap[1];
    // we first swap the root node with the last node
    swap(1, n);
    // we then decremate the n pointer to point to the new last node
    n--;
    // we then perform the top-down reheapify method, sink(),
    // starting at the root
    sink(1);
    // we then assign the old root node to null (deleteMax)
    heap[n + 1] = null;
    // if the new length of the heap is equal to 1/4th of the original length
    if (n > 0 && (n == (heap.length - 1) / 4)) {
      // cut it in half
      resize(heap.length / 2);
    }
    return max;
  }

  public void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  private void sink(int k) {
    // while 2*(current node pointer, k) is less than the number of nodes
    while (2 * k <= n) {
      // j is simply assigned to 2*(current node pointer, k)
      int j = 2 * k;
      // if j is less than the total number of nodes (it's not the last node)
      // and the node at j is less than the node at j + 1 (its sibling)
      // then j is incremented
      if (j < n && heap[j] < heap[j + 1]) {
        j++;
      }
      // if the node at k(the parent) is greater than/equal the node at j(the
      // child with the largest value) then we break out of the loop because the
      // max heap property is satisfied
      if (heap[k] >= heap[j]) {
        break;
      }
      // we then swap the node at k with the node at j
      swap(k, j);
      // and reassign the current node pointer, k, to j
      k = j;
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
    maxpq.deleteMax();
    maxpq.printMaxHeap();
    System.out.println(""); // 5 4 3 2 1
    maxpq.deleteMax();
    maxpq.printMaxHeap(); // 4 2 3 1
    System.out.println("");
  }
}
