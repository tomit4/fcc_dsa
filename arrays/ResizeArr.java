import java.util.Arrays;

public class ResizeArr {
  public int[] resize(int[] arr, int capacity) {
    int[] temp = new int[capacity];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    return temp;
  }
  public static void main(String[] args) {
    int[] array = {5, 9, 3, 10};
    ResizeArr resizedArr = new ResizeArr();
    System.out.println(Arrays.toString(resizedArr.resize(
        array, array.length * 2))); // [5, 9, 3, 10, 0, 0, 0, 0]
  }
}
