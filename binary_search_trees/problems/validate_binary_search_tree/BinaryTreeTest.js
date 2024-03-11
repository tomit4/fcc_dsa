class BinaryTreeNode {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class BinaryTree {
  constructor() {
    this.root = null;
  }

  insert(data) {
    const newNode = new BinaryTreeNode(data);
    if (this.root === null) {
      this.root = newNode;
    } else {
      this.insertNode(this.root, newNode);
    }
  }

  insertNode(node, newNode) {
    if (node.left === null) {
      node.left = newNode;
    } else if (node.right === null) {
      node.right = newNode;
    } else {
      // If both left and right nodes are already present, recursively insert on the left
      this.insertNode(node.left, newNode);
    }
  }

  isBinarySearchTree(root = this.root) {
    if (root === null) return true;
    if (root.left && root.data < root.left.data) return false;
    if (root.right && root.data > root.right.data) return false;
    return (
      this.isBinarySearchTree(root.left) && this.isBinarySearchTree(root.right)
    );
  }
}

const binaryTree = new BinaryTree();

binaryTree.insert(5);
binaryTree.insert(3);
binaryTree.insert(7);
binaryTree.insert(2);
binaryTree.insert(4);
binaryTree.insert(6);
binaryTree.insert(8);

console.log(
  "Is BinaryTree a Binary Search Tree? ",
  binaryTree.isBinarySearchTree(),
);
