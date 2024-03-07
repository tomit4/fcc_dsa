import java.util.Arrays;

public class ArrayDemo {
  public static void main(String[] args) { arrayDemo(); }
  // Time Complexity: O(n^2)
  public static void arrayDemo() {
    int[] myArray = new int[5];
    myArray[0] = 5;
    myArray[1] = 1;
    myArray[2] = 8;
    myArray[3] = 2;
    myArray[4] = 10;
    myArray[2] = 9;
    // myArray[5] = 7; // throws an exception, out of bounds
    System.out.println(Arrays.toString(myArray)); // prints [5, 1, 9, 2, 10]
  }
}
