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

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();
    bt.inOrder(bt.root); // 4 2 9 3
    System.out.println("");
  }
}

/*
 * FROM REDDIT:
A pre-order traversal takes action on the node before visiting the left
sub-tree.

An in-order traversal visits the left subtree first before taking action.

For instance, if you have a binary search tree, you may be aware that an
in-order traversal will ultimately perform its actions in ascending order (i.e.
if you made the traversal print out the node's value, you would get the values
in ascending order).
*/

/*
 * And this unfortunately sick way of abstracting it, also from REDDIT:
 *
No they're not. See the difference:

Pre Order:

Me -> Left child -> Right child

In Order:

Left child -> Me -> Right child

Post Order:

Left child -> Right child -> Me

See the order of touching nodes? In preorder you touch yourself first before
touching your children. In the inorder traversal, you touch your left child
before touching yourself.

Hope this helps.
 * */
