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

  public TreeNode search(TreeNode root, int key) {
    if (root == null || root.data == key) {
      return root;
    }
    if (key < root.data) {
      return search(root.left, key);
    } else {
      return search(root.right, key);
    }
  }

  public static void main(String[] args) {
    BinarySearchTree bST = new BinarySearchTree();
    bST.insert(5);
    bST.insert(3);
    bST.insert(7);
    bST.insert(1);

    if (null != bST.search(bST.root, 1)) {
      System.out.print("Key Found!!");
    } else {
      System.out.print("Key Not Found!!");
    }
    // "Key Found!!"

    if (null != bST.search(bST.root, 11)) {
      System.out.print("Key Found!!");
    } else {
      System.out.print("Key Not Found!!");
    }
    // "Key Not Found!!"

    System.out.println("");
  }
}
