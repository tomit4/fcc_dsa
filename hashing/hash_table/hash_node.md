## Representation Of A HashNode In A HashTable

A HashNode class in a HashTable consists of three data members:

    1. K Key - It is a unique value which helps in storing data. Here, K
       signifies a generic type.
    2. V value - It is the data that is stored based on the location computed by
       the key. Here, V signifieds a generic type.
    3. HashNode next - It refers to the next HashNode in a chain of hash nodes.

```
   HashNode
----------------
| K key        |
| V value      |
| HashNode next|
----------------
       HashNode
----------------------
| key | value| next --->
----------------------
```
