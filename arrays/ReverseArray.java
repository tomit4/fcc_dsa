import java.util.Arrays;

public class ReverseArray {
  public static void main(String[] args) {
    int[] myArray = {2, 11, 5, 10, 7, 8};
    myArray = reverseArray(myArray, 0, myArray.length - 1);
    System.out.println(Arrays.toString(myArray)); // prints [8, 7, 10, 5, 11, 2]
  }
  public static int[] reverseArray(int[] numbers, int start, int end) {
    while (start < end) {
      int temp = numbers[start];
      numbers[start] = numbers[end];
      numbers[end] = temp;
      start++;
      end--;
    }
    return numbers;
  }
}
