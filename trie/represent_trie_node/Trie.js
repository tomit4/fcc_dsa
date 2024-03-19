// https://blog.javascripttoday.com/blog/trie-data-structure/
const characters = require("./characters.js");

class TrieNode {
  constructor() {
    this.children = {};
    this.isEndOfWord = false;
  }
}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  insert(word) {
    if (!word || !word.length) {
      console.error("invalid word :=>", word);
      return;
    }
    let node = this.root;
    for (let i = 0; i < word.length; i++) {
      let char = word[i];
      if (!characters.includes(char)) {
        console.error("invalid character :=>", char);
        return;
      }
      // if this node doesn't exist down this
      // particular path of the trie tree, then create it
      if (!node.children[char]) {
        node.children[char] = new TrieNode();
      }
      // start at the next character (i.e. root -> c -> a -> t)
      node = node.children[char];
    }
    // the entire word has been traversed,
    // and the root's isEndOfWord bool is set to true
    node.isEndOfWord = true;
  }

  search(word) {
    let node = this.root;
    for (let i = 0; i < word.length; i++) {
      let char = word[i];
      if (!node.children[char]) {
        return false;
      }
      node = node.children[char];
    }
    // once we've reached the end of our searched word,
    // if the last character is indeed the end of the word
    // (i.e. so vs son, both should have true), then return true (as marked by our insert() method)
    return node.isEndOfWord;
  }

  startsWith(prefix) {
    let node = this.root;
    for (let i = 0; i < prefix.length; i++) {
      let char = prefix[i];
      if (!node.children[char]) {
        return false;
      }
      node = node.children[char];
    }
    return true;
  }
}

const trie = new Trie();

trie.insert("cat");
trie.insert("car");
trie.insert("cab");
// trie.insert("$ar"); // errors
// trie.insert(""); // errors
console.log("trie :=>", trie);
console.log("trie.root :=>", trie.root);
console.log("trie.root.children :=>", trie.root.children);
console.log("trie.root.children.c :=>", trie.root.children.c);
console.log("trie.root.children.c.children :=>", trie.root.children.c.children);
console.log(
  "trie.root.children.c.children.a.children.t :=>",
  trie.root.children.c.children.a.children.t,
);

/*
trie :=> Trie {
  root: TrieNode { children: { c: [TrieNode] }, isEndOfWord: false }
}

trie.root :=> TrieNode {
  children: { c: TrieNode { children: [Object], isEndOfWord: false } },
  isEndOfWord: false
}

trie.root.children :=> { c: TrieNode { children: { a: [TrieNode] }, isEndOfWord: false } }

trie.root.children.c :=> TrieNode {
  children: { a: TrieNode { children: [Object], isEndOfWord: false } },
  isEndOfWord: false
}

trie.root.children.c.children :=> {
  a: TrieNode {
    children: { t: [TrieNode], r: [TrieNode], b: [TrieNode] },
    isEndOfWord: false
  }
}

trie.root.children.c.children.a.children.t :=> TrieNode { children: {}, isEndOfWord: true }
*/
