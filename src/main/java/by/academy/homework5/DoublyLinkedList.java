package by.academy.homework5;

import java.io.IOException;

class DoublyLinkedListLib {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedList list, String sep) throws IOException {
        DoublyLinkedListNode currentNode = list.head;
        while (currentNode != null) {
            System.out.print(currentNode.data);
            currentNode = currentNode.next;
            if (list != null) {
                System.out.print(sep);
            }
        }
    }

    public static DoublyLinkedList reverse(DoublyLinkedList list) {
        DoublyLinkedListNode currentNode = list.tail;
        DoublyLinkedList reversedlist = new DoublyLinkedList();
        while(currentNode != null) {
            reversedlist.insertNode(currentNode.data);
            currentNode = currentNode.prev;
        }
        return reversedlist;
    }
}
