package com.byteworks.meal;

public interface LinkedList<T> {
    void add(T value);

    Node<T> find(int index);

    Node<T> getHead();

    int size();

    void removeNode(Node<T> node);

    Node<T> findNode(T meal);

    int indexOf(Node<T> node);
}
