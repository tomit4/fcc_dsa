public class BinarySearch {
  public int binarySearch(int[] nums, int key) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (high + low) / 2;
      if (nums[mid] == key)
        return mid;
      // Note that because of this condition, the array must be sorted to work
      if (key < nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 10, 20, 47, 59, 65, 75, 88, 99};
    BinarySearch bls = new BinarySearch();
    int result = bls.binarySearch(arr, 65);
    if (result == -1) {
      System.out.println("Element not found");
    } else {
      System.out.println("Element found at index " + result);
    }
  }
}
