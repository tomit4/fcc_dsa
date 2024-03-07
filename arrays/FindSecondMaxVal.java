import java.lang.Integer;

public class FindSecondMaxVal {
  public int findSecondMax(int[] vals) {
    int max = Integer.MIN_VALUE; // lowest possible int value of -2147483648
    int secondMax = Integer.MIN_VALUE;
    for (int i = 0; i < vals.length; i++) {
      if (vals[i] > max) {
        secondMax = max;
        max = vals[i];
      } else if (vals[i] > secondMax && vals[i] != max) {
        secondMax = vals[i];
      }
    }
    return secondMax;
  }

  public static void main(String[] args) {
    int[] inputArr = {12, 34, 2, 34, 33, 1};
    FindSecondMaxVal mySecondMax = new FindSecondMaxVal();
    System.out.println(mySecondMax.findSecondMax(inputArr));
  }
}
