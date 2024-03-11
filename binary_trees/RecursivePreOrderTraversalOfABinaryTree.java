public class BinaryTree {

  private TreeNode root;

  private class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int data; // Can be Generic type

    public TreeNode(int data) { this.data = data; }
  }

  public void createBinaryTree() {
    TreeNode first = new TreeNode(9);
    TreeNode second = new TreeNode(2);
    TreeNode third = new TreeNode(3);
    TreeNode fourth = new TreeNode(4);

    root = first; // root --> first
    first.left = second;
    first.right = third; // second <-- first --> third

    second.left = fourth;
  }

  public void preOrder(TreeNode root) {
    if (root == null) { // base case
      return;
    }
    System.out.print(root.data + " ");
    // Recursively assigns "root" as root.left, as well as root.right,
    // continually traversing the binary tree until all left nodes are
    // traversed, and then right.
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();
    bt.preOrder(bt.root); // 9 2 4 3
    System.out.println("");
  }
}
