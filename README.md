# MaxHeaps

This Java program implements a Max Heap data structure that manages characters. The heap organizes characters such that the largest character <br>
(in terms of its lexicographical order) is always at the root of the heap. The program supports adding characters, removing the largest character, <br>
and performing some additional operations like displaying and traversing the heap in preorder.<br>


If it's an uppercase letter ('A' to 'Z'), it adds the character to the heap using the add() method.<br>
If the character is an asterisk ('*'), it prints the root of the heap (the maximum character) and removes it using the delete() method.<br>
If the character is a hash ('#'), it displays the current state of the heap.<br>
If the character is an exclamation mark ('!'), it performs a preorder traversal of the heap and prints the result.<br>

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
