import java.util.Arrays;

public class MoveZerosToEndOfArr {
  public int[] moveZerosToEndOfArr(int[] arr, int n) {
    int j = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0 && arr[j] == 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
      if (arr[j] != 0) {
        j++;
      }
    }
    return arr;
  }
  public static void main(String[] args) {
    int[] integers = {8, 1, 0, 2, 1, 0, 3};
    MoveZerosToEndOfArr arrWithZerosAtEnd = new MoveZerosToEndOfArr();
    System.out.println(Arrays.toString(
        arrWithZerosAtEnd.moveZerosToEndOfArr(integers, integers.length)));
  }
}
