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

  isBinarySearchTree(root = this.root, min = -Infinity, max = Infinity) {
    if (root === null) return true;
    if (root.data < min || root.data > max) return false;
    return (
      this.isBinarySearchTree(root.left, min, root.data - 1) &&
      this.isBinarySearchTree(root.right, root.data + 1, max)
    );
  }
}

class BinarySearchTree extends BinaryTree {
  constructor() {
    super();
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
    if (newNode.data < node.data) {
      if (node.left === null) {
        node.left = newNode;
      } else {
        this.insertNode(node.left, newNode);
      }
    } else {
      if (node.right === null) {
        node.right = newNode;
      } else {
        this.insertNode(node.right, newNode);
      }
    }
  }
}

const binarySearchTree = new BinarySearchTree();

binarySearchTree.insert(5);
binarySearchTree.insert(3);
binarySearchTree.insert(7);
binarySearchTree.insert(2);
binarySearchTree.insert(4);
binarySearchTree.insert(6);
binarySearchTree.insert(8);

console.log(
  "Is BinarySearchTree a Binary Search Tree? ",
  binarySearchTree.isBinarySearchTree(),
);

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
