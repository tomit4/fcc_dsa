import java.lang.Integer;

public class FindMissingNum {
  public int findMissingNum(int[] arr) {
    int n = arr.length + 1;
    int sum = n * (n + 1) / 2;
    for (int num : arr) {
      sum = sum - num;
    }
    return sum;
  }
  public static void main(String[] args) {
    int[] nums = {2, 4, 1, 8, 6, 3, 7};
    FindMissingNum missingNum = new FindMissingNum();
    System.out.println(missingNum.findMissingNum(nums)); // 5
  }
}

/*
 * We can find this by using a sum of the first n natural numbers
 * For EXAMPLE:
 * the sume of first n natural numbers = 1 + 2 + 3 + 4 ... + n = n * (n + 1) /
 * 2
 * If we then continually subtract incrementally from this sum each element in
 * our array, the remainder will be our answer of which number is missing
 * */
