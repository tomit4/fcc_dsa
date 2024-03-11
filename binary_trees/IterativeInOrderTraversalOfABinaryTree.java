import java.io.*;
import java.util.*;

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

  public void iterativePreOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode temp = stack.pop();
      System.out.print(temp.data + " ");
      // NOTE: Because we are working with a Stack DS, we are first putting the
      // non-null right node on the satck, that way, when we print out each
      // node, we start with the left-most node because it is on the Top of the
      // Stack
      if (temp.right != null) {
        stack.push(temp.right);
      }
      if (temp.left != null) {
        stack.push(temp.left);
      }
    }
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

  public void inOrder(TreeNode root) {
    if (root == null) { // base case
      return;
    }
    // NOTE: the extremely similar looking code in preOrder. The difference is
    // that we are first recursively running DOWN the left tree before printing
    // any values.    preOrder(root.left);
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public void iterativeInOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    TreeNode temp = root;
    while (!stack.isEmpty() || temp != null) {
      // This if statement will traverse the temp pointer down the left side of
      // the tree until it reaches the bottom (becomes null)
      if (temp != null) {
        stack.push(temp);
        temp = temp.left;
        // Once temp = null (we've traversed all the way down the left side of
        // the tree), we then run down the right, making sure to  then take the
        // last parent node out of the stack and assigning it to temp before
        // running down right (temp = temp.right)
        // NOTE: once we grab the parent node, we then print it to the console,
        // performing our "action" on the data (the left tree is done, now take
        // a look at parent before traversing right)
      } else {
        temp = stack.pop();
        System.out.print(temp.data + " ");
        temp = temp.right;
      }
    }
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();
    bt.iterativeInOrder(bt.root); // 4 2 9 3
    System.out.println("");
  }
}
