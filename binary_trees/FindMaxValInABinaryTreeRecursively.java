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
    TreeNode first = new TreeNode(4);
    TreeNode second = new TreeNode(3);
    TreeNode third = new TreeNode(7);
    TreeNode fourth = new TreeNode(5);
    TreeNode fifth = new TreeNode(8);

    root = first; // root --> first
    first.left = second;
    first.right = third; // second <-- first --> third

    second.left = fourth;
    second.right = fifth;
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

  public void postOrder(TreeNode root) {
    if (root == null) { // base case
      return;
    }
    // NOTE: Again, very similar to preOrder and inOrder, with the major
    // difference being that now, we wait until both left and right nodes have
    // been visited before performing our "action" (i.e. printing to the
    // console).
    inOrder(root.left);
    inOrder(root.right);
    System.out.print(root.data + " ");
  }

  public void iterativePostOrder(TreeNode root) {
    TreeNode current = root;
    Stack<TreeNode> stack = new Stack<>();
    while (current != null || !stack.isEmpty()) {
      // First traverse down the left side of the tree, pushgin each leftmost
      // parent node down the stack until null is reached
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        // Once the leftside tree is traversed and our stack is full of left
        // nodes.. we then take the null's parent node (stack.peek), and assign
        // the right node, essentially traversing down the right node.
        // As long as there's a right node, the temp  pointer then takes the
        // parent node (stack.pop()), and performs our action on it (print to
        // console).
        // We then check to see if we've exhausted our stack and also if the
        // right tree node isn't null (we haven't traversed the rigth side yet),
        // and for each one, we continually pop off the stack and perform our
        // action on it
        TreeNode temp = stack.peek().right;
        if (temp == null) {
          temp = stack.pop();
          System.out.print(temp.data + " ");
          // We have completely visited both the left and right sides of the
          // tree here:
          while (!stack.isEmpty() && temp == stack.peek().right) {
            temp = stack.pop();
            System.out.print(temp.data + " ");
          }
          // However if we have reached the bottom of the right side of the
          // tree, we assign our current inspecting node (current) until it
          // becomes null (the entire tree has been traversed)
        } else {
          current = temp;
        }
      }
    }
  }

  // Level Order Traversal travels down the tree "level by level", first
  // accessing the root node, then visiting the left node of the next "level",
  // then the right node of the next "level" before proceeding down the tree to
  // the next "level" and repeating the steps until both left and right nodes
  // are null
  public void levelOrderTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    // Here we simply establish a Queue, which we utilize methods native to
    // Java's LinkedList Class. We then establish a temp TreeNode which we use
    // as a pointer to continually point to left and right tree nodes as we
    // continually poll the last node registered in the queue, moving the temp
    // the nodes kept in the poll until the queue is empty.
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode temp = queue.poll();
      System.out.print(temp.data + " ");
      if (temp.left != null) {
        queue.offer(temp.left);
      }
      if (temp.right != null) {
        queue.offer(temp.right);
      }
    }
  }

  // This is very much like preOrder, with a few comparative conditional (if)
  // statements thrown in
  public int findMax(TreeNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    // Starting at the root
    int result = root.data;
    // go down the left side of the  tree until null is reached
    int left = findMax(root.left);
    // then go down the right side of the tree until null is reached
    int right = findMax(root.right);

    // continually update the result when a greater value is found
    if (left > result)
      result = left;
    if (right > result)
      result = right;
    // and yeah...return it
    return result;
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    bt.createBinaryTree();
    System.out.print(bt.findMax(bt.root)); // 8
    System.out.println("");
  }
}
