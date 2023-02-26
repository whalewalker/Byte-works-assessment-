package com.byteworks.meal;

/**
 * This class represents a doubly-linked list.
 * @param <T> the type of data stored in the list
 */
public class LinkedListImpl<T> implements LinkedList<T> {
    private Node<T> head;
    private int size;

    /**
     * Returns the head node of the list.
     * @return the head node of the list
     */
    @Override
    public Node<T> getHead() {
        return head;
    }

    /**
     * Returns the size of the list.
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds a new node to the end of the list with the specified value.
     * @param value the value to add to the list
     */
    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setPrev(current);
        }
        size++;
    }

    /**
     * Removes the specified node from the list.
     * @param node the node to remove from the list
     */
    @Override
    public void removeNode(Node<T> node) {
        if (node == null || head == null) return;

        if (node == head) {
            head = head.getNext();
            head.setPrev(null);
            size--;
            return;
        }

        Node<T> current = head.getNext();
        while (current != null) {
            if (current == node) {
                current.getPrev().setNext(current.getNext());
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                }
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    /**
     * Finds the first node in the list with the specified value.
     * @param value the value to search for
     * @return the node with the specified value, or null if not found
     */
    @Override
    public Node<T> findNode(T meal) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(meal)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Returns the index of the specified node in the list.
     * @param node the node to find the index of
     * @return the index of the node, or -1 if not found
     */
    @Override
    public int indexOf(Node<T> node) {
        if (node == null) return -1;

        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current == node) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    /**
     * Returns the node at the specified index in the list.
     * @param index the index of the node to return
     * @return the node at the specified index, or null if the index is out of range
     */
    @Override
    public Node<T> find(int index) {
        Node<T> current;
        if (isNotValidIndex(index)) return null;
        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = head;
            for (int i = size; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }

    /**
     * Validate the index is not more than size or less than the size of the linkedList
     * @param index the index of the node
     * @return true if more than or lesser otherwise false
     */
    private boolean isNotValidIndex(int index) {
        return index < 0 || index >= size;
    }

}
