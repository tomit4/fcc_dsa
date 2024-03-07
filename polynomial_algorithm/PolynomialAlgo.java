public class PolynomialAlgo {
  public static void main(String[] args) {
    int n = 3;
    print(n);
  }
  // Time Complexity: O(n^2)
  public static void print(int n) {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.println("i=" + i + " j=" + j);
      }
      System.out.println("End of inner loop");
    }
    System.out.println("End of outer loop");
  }
}
