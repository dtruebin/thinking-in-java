package datastructures;

public class MyLinkedList<E> {
    private Node<E> head, tail;

    public MyLinkedList() {
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void append(E item) {
        Node<E> newNode = new Node<>(item, null);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public void prepend(E item) {
        Node<E> newNode = new Node<>(item, head);
        if (tail == null) {
            tail = newNode;
        }
        head = newNode;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
