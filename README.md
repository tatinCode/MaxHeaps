# MaxHeaps

This Java program implements a Max Heap data structure that manages characters. The heap organizes characters such that the largest character <br>
(in terms of its lexicographical order) is always at the root of the heap. The program supports adding characters, removing the largest character, <br>
and performing some additional operations like displaying and traversing the heap in preorder.<br>

<h2>Commands</h2>
A to Z (UPPERCASE ONLY) - adds the character to the heap using the add() method.<br>
* (asterisk) - prints the root of the heap (the maximum character) and removes it using the delete() method.<br>
# (hash) - displays the current state of the heap.<br>
! (exclamation) - performs a preorder traversal of the heap and prints the result.<br>

<h1>Sample input</h1>

```
ABCDE*!#
```

output:

```
E
E 
A B D C 
E D B A C 
```
