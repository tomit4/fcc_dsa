## What Is A Hash Table?

- It is a generalized form of an array.
- It stores the data in the form of a <em>key-value</em> pair.
- It converts the <em>key</em> to an <em>index</em> using a <em>hash</em> function.
- Taking the <em>index</em>, we store the <em>key-value</em> in an array.
- The primary operations supported by the HashTable are:

  - put(key,value) - Adds <em>key-value</em> pair against a unique key.
  - get(key) -Get <em>value</em> for the provided <em>key</em>.
  - remove(key) - Removes the <em>key-value</em> pair from the HashTable.

- The Average running time is of O(1)

- Java Collections Framework has HashMap class - if we want to deal with
  key-value pair and HashSet class if we want to deal with only keys. (my
  assumption is that this relates to JavaScript Map and Set).
