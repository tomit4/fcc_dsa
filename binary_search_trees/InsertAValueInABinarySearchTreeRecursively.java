public class BinarySearchTree {

  private TreeNode root;

  private class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(int data) { this.data = data; }
  }

  // weird javaism
  public void insert(int value) { root = insert(root, value); }

  public TreeNode insert(TreeNode root, int value) {
    if (root == null) { // base case to protect against infinite recursive loop
      root = new TreeNode(value);
      return root;
    }

    if (value < root.data) {
      root.left = insert(root.left, value);
    } else {
      root.right = insert(root.right, value);
    }

    return root;
  }

  // weird javaism
  public void inOrder() { inOrder(root); }

  public void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static void main(String[] args) {
    BinarySearchTree bST = new BinarySearchTree();
    bST.insert(5);
    bST.insert(3);
    bST.insert(7);
    bST.insert(1);
    bST.inOrder();
    // 1 3 5 7
    // note that this is an inOrder traversal, which again is the
    // complete traversal DOWN the LEFT side of the tree before
    // inspecting the values, and then going down the next right
    // side of the tree to do the same. This is also why when we performed this
    // inOrder traversal, the numbers are printed in ascending order, the nature
    // of the BST ensures that the left side of our tree will always hold values
    // that are less than their parent, while the right will always hold values
    // greater than their parent.
    System.out.println("");
  }
}
