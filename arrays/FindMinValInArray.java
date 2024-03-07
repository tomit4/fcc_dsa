public class FindMinValInArray {
  public int findMinimum(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("Invalid input");
    }
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }
  public static void main(String[] args) {
    int[] myArray = {5, 9, 3, 15, 1, 2};
    FindMinValInArray myMin = new FindMinValInArray();
    System.out.println(myMin.findMinimum(myArray)); // prints 1
  }
}
