## Representation Of A TrieNode In A Trie

A TrieNode class in a Trie consists of two data members.

1. <b>TrieNode[] children</b> - An array which refers to other TrieNodes in
   Trie, also called as child nodes of a TrieNode. The size of an array is
   usually taken as 26 (if we are storing English words, to represent the 26
   characters in the English alphabet)

2. <b>boolean isWord</b> - A boolean variable which is true if the
   current TrieNode is the end of a word in the Trie. This value is set as true
   when a word is inserted completely.

## What Is A TrieNode?

- A TrieNode in a Trie represents a single character of the word.
- In the below example, in order to insert the word, "dog", 3 TrieNodes are
  used, one for each character.

  - Example: A Trie with 4 words -

  1. dog
  2. dust
  3. hat
  4. home

```
  root-->    ()
            /  \
           /    \
         (d)    (h) <--- trienodes
         / \    / \
       (o) (u) (a) (o) <--- trienodes
        |   |   |   |
       (g) (s) (t) (m) <--- trienodes
            |       |
           (t)     (e) <--- trienodes
```

## Implementation Of The Trie Class

- A Trie will be implemented using the TrieNode class.
- A root TrieNode is at the top fo the Trie, with the empty value having 26
  links (one per character in the English alphabet).
- The links are either null or points to another TrieNode.
