package edu.chl.hajo;

/**
 * A list with positive integers, implemented as a chain of Nodes, each holding
 * an integer value.
 * 
 * @author hajo
 * 
 */
public class List<T> {
    /*
     * This isn't used to store data just to make an empty list contain a start
     * node (instead of null) Always first in list
     */
    private final Node<T> head = new Node<T>(null, null, null);
    // The number of nodes (except head) in list
    private int length = 0;

    /**
     * Add a node first (after head) in list.
     */
    public void add(T i) {
        /*if (i < 0) {
            throw new IllegalArgumentException("Only positive values allowed");
        }*/
        Node<T> tail = head.getNext();
        Node<T> n = new Node<T>(head, tail, i);
        head.setNext(n);
        length++;
    }

    public T remove() {
        if (length == 0) {
            throw new IllegalStateException("List empty");
        }
        T i = head.getNext().getValue();
        head.setNext(head.getNext().getNext());
        length--;
        return i;
    }

    // We start with index 0
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        Node<T> pos = head;
        for (int i = 0; i < index; i++) {
            pos = pos.getNext();

        }
        pos = pos.getNext();
        return pos.getValue();
    }

    public List copy() {
        Node<T> pos = head.getNext(); //first node after HEAD
        List l = new List();
        while (pos != null) {
            l.add(pos.getValue());
            pos = pos.getNext();
        }
        return l;
    }

    public int getLength() {
        return length;
    }
}
