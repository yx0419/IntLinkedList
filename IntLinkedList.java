import java.io.*;
import java.util.*;

/*
This is implementations of linkedlist with int.
*/
public class IntLinkedList {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        System.out.println(list);
        list.add(5);
        System.out.println(list);
    }

    public static class MyLinkedList {// int linkedlist

        private Node head; // 'head' is the reference variable to the first node in list (null if list is
                           // empty)

        public MyLinkedList() {// constructs a new empty list.
            head = null;
        }

        public void add(int value) {// Adds a Node with given value to the end of the list.

            if (head == null) {// if list is empty
                head = new Node(value);
                System.out.println(head);// to prove that memory address of the variable 'head' is different than the
                                         // reference variable of "list".

            } else {// if not empty, we need to traverse to the last node
                Node nNode = new Node(value, null);
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                // at this point, current refers to the last node.
                current.next = nNode;
                // System.out.println(nNode);
            }
        }

        public void add(int index, int value) {// Adds a node with the given value at the given index.
            if (index == 0) {
                Node nNode = new Node(value, head);
                head = nNode;

            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node nNode = new Node(value, current.next);
                current.next = nNode;
            }
        }

        public int get(int index) { // returns the value of a node at the given index.

            Node current = head;
            for (int i = 0; i < index; i++) {// traverse to the node at the given index.
                current = current.next;
            }
            return current.value;
        }

        public int indexOf(int value) {// returns the index of a node of first occurrence that has given value. returns
                                       // -1 if not found.

            int index = 0;
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    return index;
                } else {
                    index++;
                    current = current.next;
                }
            }
            return -1;
        }

        public void remove(int index) {// remove a node at the given index.
            if (index == 0) {
                head = head.next;

            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {// traverse to the node before the node to remove.
                    current = current.next;
                }
                current.next = current.next.next;
            }
        }

        public int size() { // returns the number of nodes in the list.
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        // public String toString() { // System.out.println() will automatically call
        // toString method instead of
        // // printing out memory address. so if I want to see the memory address, I
        // // shouldn't have toString method.

        // if (head == null) {
        // return "[]";
        // }
        // String strbuilder = "[";
        // Node current = head;
        // while (current.next != null) {
        // strbuilder += current.value + ", ";
        // current = current.next;
        // }
        // strbuilder += current.value + "]";
        // return strbuilder;
        // }

        private static class Node {

            public int value;// value stored in this node
            public Node next;// pointer(reference) to the next node

            public Node(int value) {
                this.value = value;
                this.next = null;
            }

            public Node(int value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }
}
/*
 * reference variable 'list' and 'head' contains different memory address.
 * 'list' is pointing to an object of 'MyLinkedList' class. 'head' is pointing
 * to an object of 'Node' class. 'head' is property of 'list' object. so 'list'
 * contains 'head' as a property in it. Actually, we don't necessarily need to
 * have 'MyLinkedList' class. we can only have Node class to make it work.
 * MyLinkedList makes it easier to know for example, size of the list.
 */