## What Is A Trie?

- Trie basically comes from the word Re<em>trie</em>val.
- The main purpose of this data structure is to retrieve stored information very
  fast.

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

## Applications - Auto-Complete words

- Autocomplete feature is implemented by Tries.
- Many websites have used autocomplete feature, which suggests to the user the rest of the word, while the user is typing.

## Applications - Search Contacts in phone

- Searching a person contact number in a contact list is efficiently implemented
  by a Trie. As soon as a user enters letters in an application's auto suggest
  feature, the Trie is used to find the rest of the name of the person.

## Applications - Spell Checking

- Tries help to check and correct the spelling of words entered by the user. In
  case the user doesn't know the exact spelling, a Trie can be used to auto
  suggest the correct spelling.
