/*
 * 
 * This Java program implements a Max Heap data structure that manages characters. 
 * The heap organizes characters such that the largest character (in terms of its 
 * lexicographical order) is always at the root of the heap. The program supports 
 * adding characters, removing the largest character, and performing some additional 
 * operations like displaying and traversing the heap in preorder.
 * 
 */

import java.util.Scanner;

public class MaxHeap {

        char[] heap;
        int count;

        public MaxHeap() {
                heap = new char[11];
                count = 1;
        }

        char seek() {
                return heap[1];
        }

        public void add(char c) {
                if (count == heap.length) {
                        char[] temp = heap;
                        heap = new char[temp.length + 10];
                        for (int i = 1; i < temp.length; i++) {
                                heap[i] = temp[i];
                        }
                }
                heap[count++] = c;
                int index = count - 1;
                swim(index);
        }

        void swim(int k) {
                Character newElement = heap[count - 1];
                while (k > 1 && getParent(k) < newElement) {
                        heap[k] = getParent(k);
                        k = getParentIndex(k);
                }

                // Store the new element into the correct position
                heap[k] = newElement;
        }

        // return root element
        public Character peek() {
                return heap[1];
        }

        public void delete() {
                if (heap[1] == 0)
                        return;
                int lastIndex = size();
                Character last = heap[lastIndex];
                if (lastIndex > 1) {
                        heap[1] = last;
                        sink(size());
                }
                heap[lastIndex] = '\0';
                count--;
        }

        private void sink(int k) {
                Character root = heap[1];

                int index = 1;
                boolean more = true;
                while (more) {
                        int childIndex = getLeftChildIndex(index);
                        if (childIndex <= k) {
                                Character child = getLeftChild(index);
                                if (getRightChildIndex(index) <= k && getRightChild(index).compareTo(child) > 0) {
                                        childIndex = getRightChildIndex(index);
                                        child = getRightChild(index);
                                }

                                if (child > root) {
                                        // Promote child
                                        heap[index] = child;
                                        index = childIndex;
                                } else {
                                        more = false;
                                }
                        } else {
                                more = false;
                        }
                }
                heap[index] = root;
        }

        public int size() {
                return count - 1;
        }

        private static int getLeftChildIndex(int index) {
                return 2 * index;
        }

        private static int getRightChildIndex(int index) {
                return 2 * index + 1;
        }

        private static int getParentIndex(int index) {
                return index / 2;
        }

        private Character getLeftChild(int index) {
                return heap[getLeftChildIndex(index)];
        }

        private Character getRightChild(int index) {
                return heap[getRightChildIndex(index)];
        }

        private Character getParent(int index) {
                Character c = heap[getParentIndex(index)];
                return c;
        }

        void swap(int i, int j) {
                Character temp = heap[i];
                heap[i] = heap[j];
                heap[j] = temp;
        }

        void display() {
                for (char c : heap) {
                        if (c != '\0')
                                System.out.print(c + " ");
                }
                System.out.println();
        }

        void preorder(int index) {
                if (index > size())
                        return;
                System.out.print(heap[index] + " ");
                preorder(getLeftChildIndex(index));
                preorder(getRightChildIndex(index));
        }

        // Testing
        public static void main(String[] args) {
                MaxHeap h = new MaxHeap();
                Scanner input = new Scanner(System.in);

                System.out.println("Enter a character: ");
                String stream = input.nextLine();

                for (int i = 0; i < stream.length(); i++) {
                        if (stream.charAt(i) >= 'A' && stream.charAt(i) <= 'Z')
                                h.add(stream.charAt(i));

                        else if (stream.charAt(i) == '*') {
                                System.out.println(h.seek());
                                h.delete();
                        }

                        else if (stream.charAt(i) == '#') {
                                h.display();
                        }

                        else if (stream.charAt(i) == '!') {
                                h.preorder(1);
                                System.out.println();
                        }
                }
        }
}