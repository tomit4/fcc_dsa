public class RemoveEvensFromArray {
  public int[] removeEven(int[] arr) {
    int oddCount = 0;
    // First for loop is utilized just to get the
    // amount of odd numbers, so that we can initialize
    // an array of the appropriate size
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        oddCount++;
      }
    }
    // We then initialize an array of the appropriate size for our odd integers
    int[] result = new int[oddCount];
    // We also initialize an index to keep count of when we insert a new odd
    // integer into our new odd integers array
    int idx = 0;
    for (int i = 0; i < arr.length; i++) {
      // We once again check our original array of integers to see which are odd
      if (arr[i] % 2 != 0) {
        // And if they are odd, we insert them into our new array at the new
        // index
        result[idx] = arr[i];
        // and increment our index to accept the next instance of an odd number
        idx++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    RemoveEvensFromArray obj = new RemoveEvensFromArray();
    int[] arr = {3, 2, 4, 7, 10, 6, 5};
    int[] result = obj.removeEven(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
    System.out.println(); // prints out 3 7 5
  }
}
