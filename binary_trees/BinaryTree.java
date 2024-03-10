public class BinaryTree {

  private TreeNode root;

  private class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int data; // Can be Generic type

    public TreeNode(int data) { this.data = data; }
  }

  public void createBinaryTree() {
    TreeNode first = new TreeNode(1);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);
    TreeNode fifth = new TreeNode(5);

    root = first; // root --> first
    first.left = second;
    first.right = third; // second <-- first --> third

    second.left = fourth;
    second.right = fifth;

    /*
     * n = null
     * root -->   1
     *         /     \
     *        2       3
     *     /    \   /  \
     *    4     5  n    n
     *  /  \  /  \
     * n   n n    n
     */
  }
  public static void main(String[] args) {}
}
