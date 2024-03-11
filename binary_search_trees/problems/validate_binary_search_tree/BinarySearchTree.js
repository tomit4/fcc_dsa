class Node {
  constructor(data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

class BinarySearchTree {
  constructor() {
    this.root = null;
  }

  insert(data) {
    const newNode = new Node(data);
    if (this.root === null) this.root = newNode;
    else this.insertNode(this.root, newNode);
  }

  insertNode(node, newNode) {
    if (newNode.data < node.data) {
      if (node.left === null) node.left = newNode;
      else this.insertNode(node.left, newNode);
    } else {
      if (node.right === null) node.right = newNode;
      else this.insertNode(node.right, newNode);
    }
  }

  output = "";

  inOrder(node) {
    if (node === null) return;
    this.inOrder(node.left);
    if (this.output === "") {
      this.output = node.data + " ";
    } else {
      this.output += node.data + " ";
    }
    this.inOrder(node.right);
  }

  isValid(root, min, max) {
    if (root === null) return true;
    if (root.data < min || root.data > max) return false;
    return (
      this.isValid(root.left, min, root.data - 1) &&
      this.isValid(root.right, root.data + 1, max)
    );
  }
}

const bST = new BinarySearchTree();
bST.insert(5);
bST.insert(2);
bST.insert(6);
bST.insert(1);
bST.insert(7);
bST.inOrder(bST.root);
console.log("bST.output :=>", bST.output);
console.log("bST.isValid() :=>", bST.isValid(bST.root, -Infinity, Infinity));
